package com.cyh.common.controller;

import com.cyh.plancategory.bean.PlanCategory;
import com.cyh.plancategory.mapper.PlanCategoryMapper;
import com.cyh.spare.bean.Spare;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.subclass.bean.SubClass;
import com.cyh.subclass.mapper.SubClassMapper;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: DownController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/14 10:08
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
public class DownController {
    @Autowired
    private SubClassMapper subClassMapper;
    @GetMapping("/subClass/queryAll")
    public ResultVo subClassQueryAll(){
        List<SubClass> spareList= subClassMapper.getAllSpareName();
        return ResultVoBuild.success(spareList);
    }
    @Autowired
    private PlanCategoryMapper planCategoryMapper;
    @GetMapping("planClass/queryAll")
    public ResultVo planClassQueryAll(){
        List<PlanCategory> planCategoryList=planCategoryMapper.getAllPlanCategoryName();
        return ResultVoBuild.success(planCategoryList);
    }
}
