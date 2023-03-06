package com.cyh.subclass.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @className: SubClassAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 16:17
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SubClassAdd {
    @NotBlank(message = "编码不能为空")
    private String code;
    @NotBlank(message = "名称不能为空")
    private String name;
    private Boolean status;
    private String remark;
}
