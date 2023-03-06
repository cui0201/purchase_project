package com.cyh.Tax.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: TaxPage
 * @description: 接收前端传输的条件查询数据
 * @author: CYH
 * @date: 2023/02/21 15:28
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class TaxUpdateVo {
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
     * 创建人
     */
    private String modifyPer;
    /**
     * 创建时间
     */
    private Date modifyTime;

}
