package com.cyh.util;

import com.cyh.plancategory.mapper.PlanCategoryMapper;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.subclass.mapper.SubClassMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: TestById
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/16 14:54
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public class TestById <T> {

    @Autowired
    private static PlanCategoryMapper planCategoryMapper;
    @Autowired
    private static SubClassMapper subClassMapper;


    public static ResultVo testById(Integer s,Integer p){
        Integer subCount =subClassMapper.getSubCountById(s);
        Integer planCount= planCategoryMapper.getPlanCountById(p);
        if (subCount<=0){
            return ResultVoBuild.defeated("备件小类不存在，请重新修改");
        }else

        if (planCount<=0){
            return ResultVoBuild.defeated("计划大类不存在，请重新修改！");
        }
        return ResultVoBuild.success();
    }
}
