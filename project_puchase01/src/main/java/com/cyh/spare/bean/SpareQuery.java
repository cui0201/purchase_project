package com.cyh.spare.bean;

import lombok.Data;

/**
 * @className: SpareQuery
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:46
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SpareQuery {
    private String code;
    private String name;
    private Boolean status;
    private Integer pageSize;
    private Integer pageIndex;
}
