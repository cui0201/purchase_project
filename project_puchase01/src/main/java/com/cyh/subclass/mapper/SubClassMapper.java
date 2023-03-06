package com.cyh.subclass.mapper;

import com.cyh.subclass.bean.SubClass;
import com.cyh.subclass.bean.SubClassModify;
import com.cyh.subclass.bean.SubClassPage;
import com.cyh.subclass.bean.SubClassStatus;
import com.cyh.util.ResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: SubClassMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 17:14
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface SubClassMapper {
    Integer getCountByCode(@Param("code") String code);

    Integer getCountByName(@Param("name") String name);

    void insertDate(SubClass subClass);

    void modifySubClass(SubClassModify subClassModify);

    SubClass getSubClassById(Integer id);

    Integer getCountByNameId(@Param("name") String name, @Param("id") Integer id);

    List<SubClass> querySubClassByCondition(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize, SubClassPage subClassPage);

    Integer getCountByCondition(SubClassPage subClassPage);

    void modifyStatus(SubClassStatus subClassStatus);

    List<SubClass> getAllSpareName();

    Integer getSubCountById(Integer subClassId);

    List<SubClass> querySubClass();

    void insertByImport(List<SubClass> subClasses);
}
