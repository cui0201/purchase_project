package com.cyh.spare.bean;

import lombok.Data;

import java.util.List;

/**
 * @className: SpareAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/14 16:27
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SpareAdd {
    private Integer id;
    private String code;
    private String name;
    private Boolean status;
    private Integer subClassId;
    private Integer planClassId;
    private List<Integer> legalPersonIds;
    private String createPer;
    private String modifyPer;
}
