package com.cyh.corporatefactory.bean;

import lombok.Data;

/**
 * @className: legalplantUpdate
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 12:17
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalPlantUpdate {
    private Integer id; //工厂id
    private String legalPersonCode;
    private String legalPersonName;
    private String legalPlantCode;
    private String legalPlantDec;
    private Integer version;
    private Boolean enabled;
    private String modifyPer;
}
