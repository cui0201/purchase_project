package com.cyh.corporatefactory.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: legalplant
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:12
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalPlant {
    private Integer id;
    private String legalPlantCode;
    private String legalPlantDec;
    private Boolean enabled;
    private String createTime;
    private Date createPer;
    private String modifyPer;
    private Date modifyTime;
    private Integer version;
    private Integer legalPersonId;
}
