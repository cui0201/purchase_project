package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: PriceCostPage
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 15:50
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PriceCostPage {
    /**
      *  成本价id
      */
    private Integer id;
    /**
      *  币别编码
      */
    private String currencyCode;
    /**
      *  结束的结束时间
      */
    private Date endEndTime;
    /**
      *  开始的结束时间
      */
    private Date endStartTime;
    /**
      *  法人编码
      */
    private String legalPersonCode;
    /**
      *  工厂编码
      */
    private String legalPlantCode;
    /**
      *  备件编码
      */
    private String materialCode;
    /**
      *  当前页
      */
    private Integer pageIndex;
    /**
      *  每页大小
      */
    private Integer pageSize;
    /**
      *  价格分类
      */
    private String priceType;
    /**
      *  开始的结束时间
      */
    private Date startEndTime;
    /**
      *  开始的开始时间
      */
    private Date startStartTime;
    /**
      *  状态
      */
    private Boolean status;
    /**
      *  含税类型
      */
    private Integer taxType;
    /**
     *  分页开始的位数
     */
    private Integer startNum;
}
