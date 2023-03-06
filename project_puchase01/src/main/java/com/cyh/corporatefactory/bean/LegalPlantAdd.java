package com.cyh.corporatefactory.bean;

import lombok.Data;

/**
 * @className: LegalPlantAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 11:23
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalPlantAdd {
    private Integer id; //法人id
    private String legalPersonCode;
    private String legalPersonName;
    private Boolean enabled;
    private String legalPlantCode;
    private String legalPlantDec;
    private String modifyPer;
    private String createPer;

}
