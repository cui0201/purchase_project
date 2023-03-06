package com.cyh.dictionarytable.mapper;

import com.cyh.dictionarytable.model.Dictionary;
import com.cyh.dictionarytable.model.DictionaryUpdate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: DicMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 15:21
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface DicMapper {

    /**
     * 添加字典数据
     * @param dictionary
     * @return
     */
    Boolean insert(Dictionary dictionary);

    /**
     * 查询全部数据
     * @return
     */
    List<Dictionary> queryALl();

    /**
     * 根据编码查询类别
     * @param code
     * @return
     */
    Dictionary queryTypeByCode(@Param("code") String code);

    /**
     * 修改状态
     * @param dictionaryUpdate
     */
    void updateStatus(DictionaryUpdate dictionaryUpdate);

    /**
     * 根据父类编码查询子类数据
     * @param code
     * @return
     */
    List<Dictionary> queryAllSonByParentCode(@Param("code")String code);

    /**
     * 修改子类状态
     * @param dictionaryUpdate
     */
    void updateStatusSon(DictionaryUpdate dictionaryUpdate);

    /**
     * 统计为false的有几个
     * @param dictionary
     * @return
     */
    Integer countStatusFalse(Dictionary dictionary);

    /**
     * 查询编码和名称是否已经存在
     * @param dictionary
     * @return
     */
    Integer queryForNameAndCode(Dictionary dictionary);
}
