package com.cyh.sparepartscost.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.stream.StreamUtil;
import cn.hutool.core.util.StrUtil;
import com.cyh.corporatefactory.mapper.CorporateFactoryMapper;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.sparepartscost.bean.*;
import com.cyh.sparepartscost.bean.update.PriceCostUpdateForText;
import com.cyh.sparepartscost.bean.update.PriceCostUpdateVo;
import com.cyh.sparepartscost.mapper.SpareCostMapper;
import com.cyh.sparepartscost.service.SpareCostService;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: SpareCostServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:00
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class SpareCostServiceImpl implements SpareCostService {
    @Autowired
    private SpareCostMapper spareCostMapper;
    @Autowired
    private CorporateFactoryMapper corporateFactoryMapper;
    @Autowired
    private SpareMapper spareMapper;

    @Override
    public ResultVo getPullDownList() {
        List<Status> statusList = new ArrayList<>();
        Status status = new Status("全部", null);
        Status status1 = new Status("启用", true);
        Status status2 = new Status("禁用", false);
        statusList.add(status);
        statusList.add(status1);
        statusList.add(status2);
        List<PriceType> priceTypeList = spareCostMapper.getPriceTypeList();
        List<Currency> currencyList = spareCostMapper.getCurrencyList();
        PullList list = new PullList();
        list.setStatusList(statusList);
        list.setCurrencyList(currencyList);
        list.setPriceTypeList(priceTypeList);
        return ResultVoBuild.success(list);


    }

    @Override
    public ResultVo queryPage(PriceCostPage priceCostPage) {
        Integer totalSize = spareCostMapper.getTotalSizeByCondition(priceCostPage);
        Integer startNum = (priceCostPage.getPageIndex() - 1) * priceCostPage.getPageSize();
        priceCostPage.setStartNum(startNum);
        List<PriceCostPageVo> list = spareCostMapper.queryListForPage(priceCostPage);
        for (PriceCostPageVo p : list
        ) {
            if (p.getStatus()) {
                p.setStatusName("启用");
            } else {
                p.setStatusName("禁用");
            }

        }
        PageInfo<PriceCostPageVo> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(priceCostPage.getPageIndex());
        pageInfo.setTotalSize(totalSize);
        pageInfo.setList(list);
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVo addSpareCost(PriceCostAdd priceCostAdd) {
        //根据工厂code查询工厂id
        Integer plantId = corporateFactoryMapper.getIdByPlantCode(priceCostAdd.getLegalPlantCode());
        //根据备件code查询备件id
        Integer spareId = spareMapper.getIdByCode(priceCostAdd.getMaterialCode());
        priceCostAdd.setCreatePer("创建人");
        priceCostAdd.setPlantId(plantId);
        priceCostAdd.setSpareId(spareId);
        PriceCostAdd priceCostAdd1 = new PriceCostAdd();
        BeanUtils.copyProperties(priceCostAdd,priceCostAdd1);
        //判断添加的备件价格是否和历史数据为同一个
        List<PriceCostForAdd> priceCostForAddList = spareCostMapper.getPriceCostForAdd(priceCostAdd);
        if (priceCostForAddList.size() != 0) {
            for (PriceCostForAdd list : priceCostForAddList) {
                BeanUtils.copyProperties(priceCostAdd1,priceCostAdd);
                // 1. 添加开始时间与历史开始时间相同时
                if (list.getStartTime().equals(priceCostAdd.getStartTime())) {
                    // 1.1 添加数据的结束时间在历史数据结束时间之前
                    if (priceCostAdd.getEndTime().before(list.getEndTime())) {
                        // 1.1.1 修改历史数据的开始时间是添加数据的结束时间的后一天
                        Date hisStartTime = DateUtil.offsetDay(priceCostAdd.getEndTime(), 1);
                        // 1.1.2 修改历史数据
                        spareCostMapper.updatePriceCostStartTimeById(list.getId(), hisStartTime);
                    } else {
                        //1.2 添加数据的结束时间在历史数据结束时间之后 ，直接覆盖
                        spareCostMapper.deletePriceCost(list.getId());
                    }
                } else
                    // 2. 添加的开始时间在历史开始时间之前
                    if (priceCostAdd.getStartTime().before(list.getStartTime())) {
                        // 2.1 添加的结束时间在历史结束时间之前
                        if (priceCostAdd.getEndTime().before(list.getEndTime())) {
                            // 2.1.1 修改历史数据的开始时间为添加的结束时间的后一天
                            Date hisStartTime = DateUtil.offsetDay(priceCostAdd.getEndTime(), 1);
                            // 2.1.2 修改历史数据
                            spareCostMapper.updatePriceCostStartTimeById(list.getId(), hisStartTime);
                        }else {
                            spareCostMapper.deletePriceCost(list.getId());
                        }// 3. 添加的开始时间在历史数据的开始时间之后
                    } else if (list.getStartTime().before(priceCostAdd.getStartTime())) {
                            //3.1 添加的结束时间在历史数据结束时间之前，分成三段：1. 历史开始时间+添加的开始时间的前一天 2. 添加的数据直接添加（最后操作） 3. 添加的结束时间的后一天+历史结束时间
                            if (priceCostAdd.getEndTime().before(list.getEndTime())) {
                                //3.1.1 历史开始时间+添加的开始时间的前一天 修改
                                PriceCostAdd hisPriceCost = spareCostMapper.getAllById(list.getId());
                                Date hisEndTime = DateUtil.offsetDay(priceCostAdd.getStartTime(), -1);
                                spareCostMapper.updatePriceCostEndTimeForNewDate(list.getId(), hisEndTime);
                                //3.1.2 添加的数据直接添加（最后操作）
                                //3.1.3 添加的结束时间的后一天+历史结束时间
                                Date hisStartTime = DateUtil.offsetDay(priceCostAdd.getEndTime(), 1);
                                hisPriceCost.setStartTime(hisStartTime);
                                spareCostMapper.insertSpareCost(hisPriceCost);
                            } else// 3.2 添加的结束时间在历史数据结束之后
                                if (list.getEndTime().before(priceCostAdd.getEndTime())) {

                                    Date hisEndTime = DateUtil.offsetDay(priceCostAdd.getStartTime(), -1);
                                    //3.2.1 修改历史结束时间
                                    spareCostMapper.updatePriceCostEndTimeForNewDate(list.getId(), hisEndTime);
                                    //3.2.2 最后增加
                                }
                        }
            }
        }
        spareCostMapper.insertSpareCost(priceCostAdd);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo updatePriceCostStatus(PriceCostStatus priceCostStatus) {
        Boolean result = spareCostMapper.updatePriceCostStatus(priceCostStatus);
        if (result) {
            return ResultVoBuild.success();
        } else {
            return ResultVoBuild.defeated("修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVo updatePriceCost(PriceCostUpdate priceCostUpdate) {
        //查找修改的备件文件的全部信息
        PriceCostUpdateForText oldVo = spareCostMapper.getPriceCostById(priceCostUpdate.getId());
        //查找除了时间以及价格不相同的备件价格数据
        List<PriceCostUpdateVo> list = spareCostMapper.selectAllByPriceCost(oldVo);
        for (PriceCostUpdateVo dataList : list) {
            //修改后的结束时间晚于其他除时间与价格不相同的备件价格
            if (priceCostUpdate.getEndTime().before(dataList.getEndTime())) {
                //直接修改备件价格结束时间和备注
                spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);
            } else {
                //备件价格相同时
                if (oldVo.getPrice().equals(dataList.getPrice())) {
                    if (priceCostUpdate.getEndTime().before(dataList.getEndTime())) {
                        priceCostUpdate.setEndTime(dataList.getEndTime());
                        spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);
                    } else {
                        spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);
                    }
                } else {
                    //备件价格不同时
                    //修改的结束时间早于数据库中的结束时间
                    if (priceCostUpdate.getEndTime().before(dataList.getEndTime())) {
                        spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);
                        Date oldStartTime = DateUtil.offsetDay(priceCostUpdate.getEndTime(), 1);
                        spareCostMapper.updatePriceCostStartTimeByIdForOld(priceCostUpdate.getId(), oldStartTime);
                    } else {
                        //修改的结束时间晚于数据库中的结束时间
                        spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);
                        //删除冲突的数据
                        spareCostMapper.deletePriceCost(dataList.getId());
                    }
                }

            }
        }
        spareCostMapper.updatePriceCostEndTimeForUpdate(priceCostUpdate);

        return ResultVoBuild.success();
    }
}
