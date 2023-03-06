package com.cyh.corporatefactory.mapper;

import com.cyh.corporatefactory.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: CorporateFactoryMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:23
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface CorporateFactoryMapper {
    Integer countByCondition(LegalFactoryPage legalFactoryPage);

    List<LegalFactory> queryByCondition(@Param("startNum") Integer startNum, LegalFactoryPage legalFactoryPage);

    List<LegalPer> queryLegalPer();

    void addLegalPlant(LegalPlantAdd legalPlantAdd);

    Integer getIdByLegalPer(@Param("legalPersonCode") String legalPersonCode);

    void updateStatus(LegalPlantStatus legalPlantStatus);

    void updateLegalPlant(LegalPlantUpdate legalPlantUpdate);

    List<LegalFactory> queryPlantListByLegalPersonCode(String legalPersonCode);

    Integer getIdByPlantCode(@Param("legalPlantCode")String legalPlantCode);
}
