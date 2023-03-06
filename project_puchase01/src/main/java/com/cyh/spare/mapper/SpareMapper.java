package com.cyh.spare.mapper;

import com.cyh.corporatefactory.bean.LegalPer;
import com.cyh.spare.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: SpareMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:57
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface SpareMapper {
    Integer getCountByCondition(SpareQuery spareQuery);

    List<SpareQueryAllArg> getAllByCondition(@Param("startNum") Integer startNum, SpareQuery spareQuery);

    void updateStatus(SpareStatus spareStatus);

    Integer AddSpare(SpareAdd spareAdd);


    Integer getIdByCode(String code);

    void AddSpareLegal(@Param("id") Integer id, @Param("legalPersonIds") List<Integer> legalPersonIds);

    List<LegalPer> getLegalPerson(@Param("id") Integer id);

    void modifySpare(SpareUpdate spareUpdate);

    void modifySparePerson(@Param("id") Integer id, @Param("LegalPersonId") Integer LegalPersonId);

    List<Integer> getIdBySpareId(Integer id);

    void deleteSpare(Integer id);

    List<SpareLegalPersonPage> getAllLegalPerson(List legalPages);

    List<SpareSubclass> getPersonIdByCode(String legalPersonCode);

    /**
     * @param legalPersonId
     * @return java.util.List<com.cyh.spare.bean.SpareForThresholdValue>
     * @description:阈值设置备件下拉列表
     */
    List<SpareForThresholdValue> getSpareByLegalPerson(@Param("legalPersonId") Integer legalPersonId);
}
