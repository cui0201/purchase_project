package com.cyh.subclass.bean;

import lombok.Data;

/**
 * @className: SubClassPage
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/08 16:47
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SubClassPage {
    private String code;
    private String name;
    private Boolean status;
    private Integer pageIndex;
    private Integer pageSize;

}
