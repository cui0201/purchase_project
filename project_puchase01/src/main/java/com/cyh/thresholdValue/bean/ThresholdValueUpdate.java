package com.cyh.thresholdValue.bean;

import lombok.Data;

/**
 * @className: ThresholdValueUpdate
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/20 19:11
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ThresholdValueUpdate {
    /**
            * 阈值id
            * @return 
            * @description:
            */
    private Integer id;
    /**
     * 备注
     *
     * @return
     * @description:
     */
    private String description;
    /**
     * 备件编码
     *
     * @return
     * @description:
     */
    private String spareCode;
    /**
     * 备件名称
     *
     * @return
     * @description:
     */
    private String spareName;
    /**
     * 备件小类名称
     *
     * @return
     * @description:
     */
    private String subClassName;
    /**
     * 阈值
     *
     * @return
     * @description:
     */
    private String thresholdValue;
}
