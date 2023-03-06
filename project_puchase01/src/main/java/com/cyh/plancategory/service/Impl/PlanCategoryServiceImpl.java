package com.cyh.plancategory.service.Impl;

import com.cyh.corporatefactory.bean.LegalFactoryForPlantList;
import com.cyh.plancategory.bean.*;
import com.cyh.plancategory.mapper.PlanCategoryMapper;
import com.cyh.plancategory.service.PlanCategoryService;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: PlanCategoryServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 11:10
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class PlanCategoryServiceImpl implements PlanCategoryService {

    @Autowired
    private PlanCategoryMapper planCategoryMapper;
    @Override
    public ResultVo queryPage(PlanCategoryPage planCategoryPage) {
        int startNum=planCategoryPage.getPageSize()*(planCategoryPage.getPageIndex()-1);
        int count= planCategoryMapper.getCountByCondition(planCategoryPage);
        List<PlanCategory> pageInfoList= planCategoryMapper.queryPage(startNum,planCategoryPage);
        for (PlanCategory plan:pageInfoList){
            if (plan.getStatus()){
                plan.setStatusName("启用");
            }else {
                plan.setStatusName("禁用");
            }
        }
        PageInfo<PlanCategory> pageInfo =new PageInfo<>();
        pageInfo.setPageSize(planCategoryPage.getPageSize());
        pageInfo.setCurrentPage(planCategoryPage.getPageIndex());
        pageInfo.setTotalSize(count);
        pageInfo.setList(pageInfoList);
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    public ResultVo addPlanCategory(PlanCategoryAdd planCategoryAdd) {
        planCategoryAdd.setCreatePre("小虎");
        planCategoryAdd.setModifyPre("小虎");
        planCategoryMapper.addPlanCategory(planCategoryAdd);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo updateStatus(PlanCategoryStatus planCategoryStatus) {
        planCategoryStatus.setModifyPre("修改人");
        planCategoryMapper.updateStatus(planCategoryStatus);
        return ResultVoBuild.success();

    }

    @Override
    public ResultVo update(PlanCategoryModify planCategoryModify) {
        planCategoryMapper.update(planCategoryModify);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo queryPlantListByLegalPersonCode(String legalPersonCode) {
       Integer legalPersonId= planCategoryMapper.getlegalPersonIdByCode(legalPersonCode);
       List<LegalFactoryForPlantList> list= planCategoryMapper.queryPlantListByLegalPersonCode(legalPersonId);
       return ResultVoBuild.success(list);
    }

}
