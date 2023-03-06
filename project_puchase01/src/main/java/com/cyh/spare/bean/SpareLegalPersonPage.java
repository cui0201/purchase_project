package com.cyh.spare.bean;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

/**
 * @className: SpareLegalPersonPage
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/16 19:50
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SpareLegalPersonPage {
    private Integer spareId;
    private String legalPersonName;
}
