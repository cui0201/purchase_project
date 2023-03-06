package com.cyh.thresholdValue.service.Impl;

import com.cyh.corporatefactory.mapper.CorporateFactoryMapper;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.thresholdValue.bean.ThresholdValueAdd;
import com.cyh.thresholdValue.bean.ThresholdValuePage;
import com.cyh.thresholdValue.bean.ThresholdValuePageVo;
import com.cyh.thresholdValue.bean.ThresholdValueUpdate;
import com.cyh.thresholdValue.mapper.ThresholdValueMapper;
import com.cyh.thresholdValue.service.ThresholdValueService;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cyh.util.ParamUtil.VALUE_MAX;

/**
 * @className: ThresholdValueServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/17 14:42
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class ThresholdValueServiceImpl implements ThresholdValueService {

    @Autowired
    private ThresholdValueMapper thresholdValueMapper;
    @Autowired
    private CorporateFactoryMapper corporateFactoryMapper;
    @Autowired
    private SpareMapper spareMapper;

    @Override
    public ResultVo queryAll(ThresholdValuePage thresholdValuePage) {

        Integer totalSize = thresholdValueMapper.countTotalPageSize(thresholdValuePage);
        Integer startNum = (thresholdValuePage.getPageIndex() - 1) * thresholdValuePage.getPageSize();
        thresholdValuePage.setStartNum(startNum);
        List<ThresholdValuePageVo> list = thresholdValueMapper.queryAllForList(thresholdValuePage);
        for (ThresholdValuePageVo a : list) {
            if (a.getStatus()) {
                a.setStatusName("启用");
            } else {
                a.setStatusName("禁用");
            }
            if (a.getBorrowStatus()) {
                a.setBorrowStatusName("启用");
            } else {
                a.setBorrowStatusName("禁用");
            }
            if (a.getSellStatus()) {
                a.setSellStatusName("启用");
            } else {
                a.setSellStatusName("禁用");
            }
        }
        PageInfo<ThresholdValuePageVo> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(thresholdValuePage.getPageIndex());
        pageInfo.setList(list);
        pageInfo.setTotalSize(totalSize);
        pageInfo.setPageSize(thresholdValuePage.getPageSize());
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    public ResultVo add(ThresholdValueAdd thresholdValueAdd) {
        if(thresholdValueAdd.getFazhi()>VALUE_MAX){
            return ResultVoBuild.defeated("阈值不能大于9999");
        }
        Integer legalPersonId = corporateFactoryMapper.getIdByLegalPer(thresholdValueAdd.getLegalPersonCode());
        Integer spareId = spareMapper.getIdByCode(thresholdValueAdd.getSpareCode());
        thresholdValueAdd.setLegalPersonId(legalPersonId);
        thresholdValueAdd.setSpareId(spareId);
        thresholdValueAdd.setCreatePer("创建人");
        thresholdValueAdd.setStatus(true);
        thresholdValueAdd.setBorrowStatus(true);
        thresholdValueAdd.setSellStatus(true);
        Boolean result = thresholdValueMapper.addThresholdValue(thresholdValueAdd);
        if (result) {
            return ResultVoBuild.success();
        }

        return ResultVoBuild.defeated("新增失败，请尝试重新添加");
    }

    @Override
    public ResultVo update(ThresholdValueUpdate thresholdValueUpdate) {
        Boolean result = thresholdValueMapper.updateThresholdValue(thresholdValueUpdate);
        if (result) {
            return ResultVoBuild.success();
        }
        return ResultVoBuild.defeated("修改失败，请尝试重新添加");
    }
}
