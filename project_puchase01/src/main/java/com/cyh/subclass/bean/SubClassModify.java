package com.cyh.subclass.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.naming.Name;

/**
 * @className: SubClassModify
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/08 11:16
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SubClassModify {
    private Integer id;
    @NotBlank(message = "备件名称为空，请添加备件名称！！！")
    private String name;
    private Boolean status;
    private String remark;
    private String modifyPer;
    private Integer version;
}
