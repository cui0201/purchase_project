package com.cyh.spare.bean;

import lombok.Data;

import java.util.Date;

/**
 * @className: Spare
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:43
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class Spare {
    private Integer id;
    private String code;
    private String name;
    private Boolean  status;
    private String createPer;
    private Date createTime;
    private String modify_per;
    private Date modify_time;
    private Integer version;

}
