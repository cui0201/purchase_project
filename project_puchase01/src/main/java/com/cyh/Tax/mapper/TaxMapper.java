package com.cyh.Tax.mapper;

import com.cyh.Tax.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: TaxMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/21 15:20
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface TaxMapper {
    /**
     * 根据条件查询展示总条数
     *
     * @param taxPage
     * @return Integer
     */
    Integer getTotalSizeByCondition(TaxPage taxPage);

    /**
     * 根据条件查询数据
     *
     * @param taxPage
     * @return List<TaxPageVo>
     */
    List<TaxPageVo> getPageListByCondition(TaxPage taxPage);

    /**
     * 新增税码税率
     *
     * @param taxAddVo
     * @return Boolean
     */
    Boolean addTax(TaxAddVo taxAddVo);

    /**
     * 检验是否有重复税码
     *
     * @param taxAddVo
     * @return Integer
     */
    Integer textTaxCode(TaxAddVo taxAddVo);

    /**
     * 修改tax
     *
     * @param taxUpdateVo
     * @return Boolean
     */
    Boolean updateTax(TaxUpdateVo taxUpdateVo);

    /**
     * 修改状态
     *
     * @param taxAddVo
     * @return Boolean
     */
    Boolean updateStatus(TaxAddVo taxAddVo);

    /**
     * 查询所有含税类型
     *
     * @param
     * @return List<TaxQueryAll>
     */
    List<TaxQueryAll> queryAllTaxType();
}
