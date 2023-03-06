package com.cyh.plancategory.service;

import com.cyh.plancategory.bean.PlanCategoryAdd;
import com.cyh.plancategory.bean.PlanCategoryModify;
import com.cyh.plancategory.bean.PlanCategoryPage;
import com.cyh.plancategory.bean.PlanCategoryStatus;
import com.cyh.util.ResultVo;

/**
 * @className: PlanCategoryService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 11:09
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface PlanCategoryService {

    ResultVo queryPage(PlanCategoryPage planCategoryPage);

    ResultVo addPlanCategory(PlanCategoryAdd planCategoryAdd);

    ResultVo updateStatus(PlanCategoryStatus planCategoryStatus);

    ResultVo update(PlanCategoryModify planCategoryModify);

    ResultVo queryPlantListByLegalPersonCode(String legalPersonCode);
}
