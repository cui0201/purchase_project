package com.cyh.sparepartscost.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: currency
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:22
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@AllArgsConstructor

public class Currency {
    /**
      *  标签名
      */
    private String label;
    /**
      *  值大小
      */
    private String value;
}
