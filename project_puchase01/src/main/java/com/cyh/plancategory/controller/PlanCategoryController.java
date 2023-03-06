package com.cyh.plancategory.controller;

import com.cyh.plancategory.bean.PlanCategoryAdd;
import com.cyh.plancategory.bean.PlanCategoryModify;
import com.cyh.plancategory.bean.PlanCategoryPage;
import com.cyh.plancategory.bean.PlanCategoryStatus;
import com.cyh.plancategory.service.PlanCategoryService;
import com.cyh.util.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: PlanCategroyController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 11:07
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@RequestMapping("/planCategory")
public class PlanCategoryController {

    @Autowired
    private PlanCategoryService planCategoryService;

    @PostMapping("/queryPage")
    public ResultVo queryPage(@RequestBody PlanCategoryPage planCategoryPage) {
        return planCategoryService.queryPage(planCategoryPage);
    }

    @PostMapping("/add")
    public ResultVo addPlanCategory(@RequestBody PlanCategoryAdd planCategoryAdd) {
        return planCategoryService.addPlanCategory(planCategoryAdd);
    }

    /**
     * @param
     * @return com.cyh.util.ResultVo
     * @description:
     */
    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody PlanCategoryStatus planCategoryStatus) {
        return planCategoryService.updateStatus(planCategoryStatus);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody PlanCategoryModify planCategoryModify) {
        return planCategoryService.update(planCategoryModify);
    }
    @GetMapping("/queryPlantListByLegalPersonCode")
    public ResultVo queryPlantListByLegalPersonCode(@RequestParam("legalPersonCode") String legalPersonCode){
        return planCategoryService.queryPlantListByLegalPersonCode(legalPersonCode);
    }

}
