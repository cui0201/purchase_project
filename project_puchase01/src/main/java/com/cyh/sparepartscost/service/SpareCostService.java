package com.cyh.sparepartscost.service;

import com.cyh.sparepartscost.bean.PriceCostAdd;
import com.cyh.sparepartscost.bean.PriceCostPage;
import com.cyh.sparepartscost.bean.PriceCostStatus;
import com.cyh.sparepartscost.bean.PriceCostUpdate;
import com.cyh.util.ResultVo;

/**
 * @className: SpareCostService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:00
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface SpareCostService {
    /**
     * 页面税务类型，币憋，状态，下拉列表
     *
     * @param
     * @return ResultVo
     */
    ResultVo getPullDownList();

    /**
     * 条件分页查询
     *
     * @param priceCostPage
     * @return ResultVo
     */
    ResultVo queryPage(PriceCostPage priceCostPage);

    /**
     * 添加
     *
     * @param priceCostAdd
     * @return ResultVo
     */
    ResultVo addSpareCost(PriceCostAdd priceCostAdd);

    /**
     * 修改状态
     *
     * @param priceCostStatus
     * @return ResultVo
     */
    ResultVo updatePriceCostStatus(PriceCostStatus priceCostStatus);

    /**
     * 修改备件价格
     * @param priceCostUpdate
     * @return ResultVo
     */
    ResultVo updatePriceCost(PriceCostUpdate priceCostUpdate);
}
