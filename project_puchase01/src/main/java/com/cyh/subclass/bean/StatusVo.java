package com.cyh.subclass.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: StatusVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/09 15:39
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusVo {
    private String label;
    private Integer value;
}
