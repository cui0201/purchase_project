package com.cyh.plancategory.bean;

import lombok.Data;

/**
 * @className: PlanCategoryModify
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 18:58
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PlanCategoryModify {
    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private String remark;
    private Integer version;
    private String modifyPre;
}
