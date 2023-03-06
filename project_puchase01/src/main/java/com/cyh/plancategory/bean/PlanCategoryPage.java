package com.cyh.plancategory.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: PlanCategoryPage
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 11:16
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@AllArgsConstructor
public class PlanCategoryPage {
    private String code;
    private String name;
    private Boolean status;
    private Integer pageIndex;
    private Integer pageSize;

}
