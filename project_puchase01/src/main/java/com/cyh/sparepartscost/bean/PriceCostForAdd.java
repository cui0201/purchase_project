package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: PriceCostForAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/23 10:57
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PriceCostForAdd {
    /**
     * 相同的备件价格id
     */
    private Integer id;
    /**
     * 备件价格
     */
    private BigDecimal price;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date EndTime;
    /**
      *  备注
      */
    private String remark;

}
