package com.cyh.corporatefactory.bean;

import lombok.Data;

/**
 * @className: LeaglDactory
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 23:05
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalFactory {
    private String legalPlantCode;//工厂编码

    private String legalPlantDec;//工厂描述

    private Boolean enabled; //工厂状态

    private String legalPersonCode;//法人编码

    private String legalPersonName; //法人名称

    private Integer id;//法人工厂id

    private Integer legalPersonId;//工厂表的法人id

    private Integer version; //工厂版本号
}
