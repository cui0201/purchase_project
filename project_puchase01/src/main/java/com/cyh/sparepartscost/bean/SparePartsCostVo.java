package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: SparePartsCostVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/06 10:30
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SparePartsCostVo {
    /**
     *  备件价格id
     */
    private Integer id;
    /**
     * 币别编码
     */
    private String currencyCode;
    /**
     * 法人编码
     */
    private String legalPersonCode;
    /**
     * 备件编码
     */
    private String materialCode;
    /**
     * 工厂编码
     */
    private String legalPlantCode;
    /**
     * 备件单价
     */
    private BigDecimal price;
    /**
     * 价格分类
     */
    private String priceType;
    /**
     * 含税类型
     */
    private Integer taxType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 工厂id
     */
    private Integer plantId;
    /**
     * 备件id
     */
    private Integer spareId;
    /**
     * 创建人
     */
    private String createPer;
}
