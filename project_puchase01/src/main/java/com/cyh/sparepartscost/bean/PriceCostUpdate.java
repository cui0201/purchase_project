package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: PriceCostUpdate
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/23 15:19
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PriceCostUpdate {
    private Integer id;
    private BigDecimal price;
    private String remark;
    private Date endTime;
}
