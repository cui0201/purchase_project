package com.cyh.plancategory.bean;

import lombok.Data;

/**
 * @className: PlanCategoryAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 16:53
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PlanCategoryAdd {
    private String code;
    private String name;
    private String remark;
    private Boolean status;
    private String createPre;
    private String modifyPre;
}
