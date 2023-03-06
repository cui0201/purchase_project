package com.cyh.spare.bean;

import com.cyh.corporatefactory.bean.LegalPer;
import lombok.Data;

import java.util.List;

/**
 * @className: SpareQueryAllArg
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:50
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SpareQueryAllArg {

    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private String subClassName;
    private String planClassName;
    private String legalPersonName;
    private String statusName;
}
