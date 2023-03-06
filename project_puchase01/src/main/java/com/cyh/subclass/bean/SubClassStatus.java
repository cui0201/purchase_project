package com.cyh.subclass.bean;

import lombok.Data;

/**
 * @className: SubClassStatus
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/08 20:05
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SubClassStatus {
    private Integer id;
    private Boolean status;
    private String modifyPer;
    private Integer version;
}
