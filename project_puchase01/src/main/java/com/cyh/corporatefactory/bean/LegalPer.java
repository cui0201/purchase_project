package com.cyh.corporatefactory.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: LegalPer
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:18
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class LegalPer {
    private Integer id;
    private String legalPersonCode;
    private String legalPersonName;
    private Boolean enabled;
    private Date createTime;
    private String createPer;
    private Date modifyTime;
    private String modifyPer;
    private Integer version;
}
