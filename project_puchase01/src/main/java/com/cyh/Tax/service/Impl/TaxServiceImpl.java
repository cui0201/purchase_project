package com.cyh.Tax.service.Impl;

import cn.hutool.core.util.RandomUtil;
import com.cyh.Tax.bean.*;
import com.cyh.Tax.mapper.TaxMapper;
import com.cyh.Tax.service.TaxService;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: TaxServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/21 15:20
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class TaxServiceImpl implements TaxService {
    @Resource
    private TaxMapper taxMapper;

    @Override
    public ResultVo queryPageByConditionForPage(TaxPage taxPage) {
        //获取分页查询时开始数
        Integer startNum = (taxPage.getPageIndex() - 1) * taxPage.getPageSize();
        //计算分页查询时的总数量totalSize
        Integer totalSize = taxMapper.getTotalSizeByCondition(taxPage);
        taxPage.setStartNum(startNum);
        //条件查询所有数据
        List<TaxPageVo> taxPageVoList = taxMapper.getPageListByCondition(taxPage);
        for (TaxPageVo t : taxPageVoList
        ) {
            if (t.getStatus()) {
                t.setStatusName("启用");
            } else {
                t.setStatusName("禁用");
            }
        }
        PageInfo<TaxPageVo> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(taxPage.getPageIndex());
        pageInfo.setTotalSize(totalSize);
        pageInfo.setList(taxPageVoList);
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    public ResultVo addTax(TaxAddVo taxAddVo) {
        taxAddVo.setCreatePer("创建人" + RandomUtil.randomString(3));
        //检验税码是否重复
        Integer count = taxMapper.textTaxCode(taxAddVo);
        if (count>0){
            return ResultVoBuild.defeated("税码重复，请重新添加!!");
        }
        Boolean result = taxMapper.addTax(taxAddVo);
        if (result) {
            return ResultVoBuild.success();
        } else {
            return ResultVoBuild.defeated("添加未成功");
        }

    }

    @Override
    public ResultVo updateTax(TaxUpdateVo taxUpdateVo) {
        taxUpdateVo.setModifyPer("修改人"+RandomUtil.randomString(2));
        Boolean result = taxMapper.updateTax(taxUpdateVo);

        if (result) {
            return ResultVoBuild.success();
        } else {
            return ResultVoBuild.defeated("修改未成功！！");
        }
    }

    @Override
    public ResultVo updateStatus(TaxAddVo taxAddVo) {
        Boolean result = taxMapper.updateStatus(taxAddVo);

        if (result) {
            return ResultVoBuild.success();
        } else {
            return ResultVoBuild.defeated("修改未成功！！");
        }
    }

    @Override
    public ResultVo queryAllTaxType() {
        List<TaxQueryAll> taxList=taxMapper.queryAllTaxType();
        //字符串凭借：含税类型
        /*for (TaxQueryAll tax:taxList) {

        }*/

        return ResultVoBuild.success(taxList);
    }
}
