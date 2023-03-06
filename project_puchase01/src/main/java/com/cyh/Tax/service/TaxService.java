package com.cyh.Tax.service;

import com.cyh.Tax.bean.TaxAddVo;
import com.cyh.Tax.bean.TaxPage;
import com.cyh.Tax.bean.TaxUpdateVo;
import com.cyh.util.ResultVo;

/**
 * @className: TaxService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/21 15:20
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface TaxService {
    /**
     * 分页查询展示数据
     *
     * @param taxPage
     * @return com.cyh.util.ResultVo
     */
    ResultVo queryPageByConditionForPage(TaxPage taxPage);

    /**
     * 新增税码税率
     *
     * @param taxAddVo
     * @return ResultVo
     */
    ResultVo addTax(TaxAddVo taxAddVo);

    /**
     * 修改税码
     *
     * @param taxUpdateVo
     * @return ResultVo
     */
    ResultVo updateTax(TaxUpdateVo taxUpdateVo);

    /**
     * 修改状态
     *
     * @param taxAddVo
     * @return ResultVo
     */
    ResultVo updateStatus(TaxAddVo taxAddVo);

    /**
     * 查找全部含税类型
     *
     * @param
     * @return ResultVo
     */
    ResultVo queryAllTaxType();
}
