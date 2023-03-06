package com.cyh.dictionarytable.model;

import lombok.Data;

/**
 * @className: DictionaryUpdate
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 16:35
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class DictionaryUpdate {
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态
     */
    private Boolean status;
}
