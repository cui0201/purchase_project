package com.cyh.spare.bean;

import lombok.Data;

import java.util.List;

/**
 * @className: SpareUpdate
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/14 18:54
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SpareUpdate {
    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private Integer subClassId;
    private Integer planClassId;
    private List<Integer> legalPersonId;
    private String createPer;
    private String modifyPer;
}
