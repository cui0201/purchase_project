package com.cyh.corporatefactory.bean;

import lombok.Data;

/**
 * @className: LegalPlantStatus
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 12:05
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalPlantStatus {
    private Integer id; //工厂id
    private String legalPersonCode;
    private String legalPlantCode;
    private Boolean enabled;
    private String modifyPer;

}
