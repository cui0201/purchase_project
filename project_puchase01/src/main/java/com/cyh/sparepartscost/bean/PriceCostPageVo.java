package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: PriceCostPageVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 16:51
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PriceCostPageVo {
    private Integer id;
    private String spareCode;
    private String spareName;
    private String legalPlantDec;
    private String priceType;
    private String priceTypeName;
    private String currencyCode;
    private String currencyCodeName;
    private String taxDec;
    private String materialUnit;
    private BigDecimal price;
    private Date startTime;
    private Date endTime;
    private Boolean  status;
    private String statusName;
    private String creatorName;
    private String remark;
    private String legalPersonCode;
    private String legalPersonName;
}
