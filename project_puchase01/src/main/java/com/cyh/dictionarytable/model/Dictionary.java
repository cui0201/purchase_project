package com.cyh.dictionarytable.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: Dictionary
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 15:06
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@NoArgsConstructor
public class Dictionary {
    /**
     * 类型：0父类，1子类
     */
    private Integer type;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 父类编码
     */
    private String parentCode;
    /**
     * 创建人
     */
    private String createPer;
    /**
     * 状态
     */
    private Boolean status;
    /**
      *  备注
      */
    private String marker;
}
