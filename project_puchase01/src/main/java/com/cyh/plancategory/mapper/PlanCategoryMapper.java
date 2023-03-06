package com.cyh.plancategory.mapper;

import com.cyh.corporatefactory.bean.LegalFactoryForPlantList;
import com.cyh.plancategory.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: PlanCategoryMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 11:11
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface PlanCategoryMapper {
    int getCountByCondition(PlanCategoryPage planCategoryPage);

    List<PlanCategory> queryPage(@Param("startNum") int startNum, PlanCategoryPage planCategoryPage);

    void addPlanCategory(PlanCategoryAdd planCategoryAdd);

    PlanCategory getPlanCategoryById(Integer id);

    void updateStatus(PlanCategoryStatus planCategoryStatus);

    void update(PlanCategoryModify planCategoryModify);

    List<PlanCategory> getAllPlanCategoryName();

    Integer getPlanCountById(Integer planClassId);

    Integer getlegalPersonIdByCode(@Param("legalPersonCode") String legalPersonCode);

    List<LegalFactoryForPlantList> queryPlantListByLegalPersonCode(@Param("legalPersonId") Integer legalPersonId);
}
