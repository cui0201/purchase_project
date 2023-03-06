package com.cyh.Tax.bean;

import lombok.Data;

/**
 * @className: TaxPage
 * @description: 接收前端传输的条件查询数据
 * @author: CYH
 * @date: 2023/02/21 15:28
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class TaxPage {
    private Integer id;
    /**
     * 税码
     */
    private String taxCode;
    /**
     * 税率
     */
    private Integer tax;
    /**
     * 税码描述
     */
    private String taxDec;
    /**
     * 税码状态
     */
    private Boolean status;
    /**
     * 当前页数
     */
    private Integer pageIndex;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 分页开始的条数
     */
    private Integer startNum;

}
