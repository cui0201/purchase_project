package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: ImportModel
 * @description: 导入成本价实体类
 * @author: CYH
 * @date: 2023/03/06 14:14
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ImportModel {
    /**
     * 价格类型
     */
    private String priceType;

    /**
     * 法人编码
     */
    private String legalPersonCode;
    /**
     * 备件编码
     */
    private String spareCode;
    /**
     * 备件名称
     */
    private String spareName;
    /**
     * 税码
     */
    private String taxCode;
    /**
     * 备件价格
     */
    private BigDecimal sparePrice;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

}
