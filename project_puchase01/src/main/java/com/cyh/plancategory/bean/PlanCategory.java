package com.cyh.plancategory.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @className: PlanCategory
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 10:40
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanCategory {
    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private String remark;
    private String createPre;
    private Date createTime;
    private String modifyPre;
    private Date modifyTime;
    private Integer version;
    private String statusName;

}
