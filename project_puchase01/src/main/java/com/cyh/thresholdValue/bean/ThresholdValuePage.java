package com.cyh.thresholdValue.bean;

import jakarta.validation.constraints.Max;
import lombok.Data;

import java.util.Date;

/**
 * @className: ThresholdValue
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/20 11:27
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ThresholdValuePage {
    private Integer id;
    /**
     * 阈值开始数量
     */
    private Integer fazhiStart;
    /**
     * 阈值结束数量
     */
    @Max(value = 9999,message = "数量过大，请重试")
    private Integer fazhiEnd;
    /**
     * 备件小类编码
     */
    private String subclassCode;
    /**
     * 法人编码
     */
    private String legalPersonCode;
    /**
     * 修改人
     */
    private String updateName;
    /**
     * 修改开始时间
     */
    private Date updateTimeStart;
    /**
     * 修改结束时间
     */
    private Date updateTimeEnd;

    private Integer pageIndex;

    private Integer pageSize;

    private Integer startNum;
    /**
     * 备件编码
     */
    private String spareCode;

}
