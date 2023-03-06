package com.cyh.thresholdValue.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: ThresholdValuePageVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/20 13:10
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ThresholdValuePageVo {
    private String id;
    private String spareCode;
    private String spareName;
    private String unit;
    private String subClassName;
    private Integer thresholdNum;
    private Boolean status;
    private String statusName;
    private Boolean borrowStatus;
    private String borrowStatusName;
    private Boolean sellStatus;
    private String sellStatusName;
    private String description;
    private String legalName;
    private String createPer;
    private Date createTime;
    private Date modifyTime;
    private String modifyPer;
}
