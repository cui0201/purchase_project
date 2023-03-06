package com.cyh.thresholdValue.bean;

import jakarta.validation.constraints.Max;
import lombok.Data;
import org.springframework.web.util.pattern.PathPattern;

/**
 * @className: ThresholdValueAdd
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/20 15:59
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ThresholdValueAdd {

    /**
     * 法人编码
     *
     * @return
     * @description:
     */
    private String legalPersonCode;
    /**
     * 阈值
     *
     * @return
     * @description:不能大于9999
     */
    @Max(value = 9999,message = "阈值不能大于9999")
    private Integer fazhi;
    /**
     * 描述，备注
     *
     * @return
     * @description:
     */
    private String remark;
    /**
     * 备件编码
     *
     * @return
     * @description:
     */
    private String spareCode;
    /**
     * 备件id
     *
     * @return
     * @description:
     */
    private Integer spareId;
    /**
            * 法人id
            * @return 
            * @description:
            */
    private Integer legalPersonId;
    /**
     * 创建人
     *
     * @return
     * @description:
     */
    private String createPer;
    private Boolean status;
    private Boolean borrowStatus;
    private Boolean sellStatus;

}
