package com.cyh.sparepartscost.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: StatusList
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:15
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@AllArgsConstructor
public class Status {
    private String label;
    private Boolean value;
}
