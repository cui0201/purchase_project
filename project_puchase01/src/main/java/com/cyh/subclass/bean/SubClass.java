package com.cyh.subclass.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

/**
 * @className: SubClass
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 15:09
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SubClass {
    private Integer id;

    @NotBlank(message = "小类编码不能为空")
    private String code;

    @NotBlank(message = "小类名称不能为空")
    private String name;

    private Boolean status;

    private String remark;

    private Date createTime;

    private String createPer;

    private Date modifyTime;

    private String modifyPer;

    private Integer version;

    private String statusName;

}
