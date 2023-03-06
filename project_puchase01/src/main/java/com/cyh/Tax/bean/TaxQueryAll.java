package com.cyh.Tax.bean;

import lombok.Data;

/**
 * @className: TaxQueryAll
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/21 22:18
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class TaxQueryAll {
    /**
     * taxId
     */
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
}
