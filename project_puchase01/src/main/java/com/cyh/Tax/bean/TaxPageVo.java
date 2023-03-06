package com.cyh.Tax.bean;


import lombok.Data;

import java.util.Date;

/**
 * @className: TaxPageVo
 * @description: 后端穿前端实体类
 * @author: CYH
 * @date: 2023/02/21 15:43
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class TaxPageVo {
    private Integer id;
    /**
     * 税码
     */
    private String taxCode;
    /**
     * 税率
     */
    private Integer taxRate;
    /**
     * 税码描述
     */
    private String taxDec;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 创建人
     */
    private String createPer;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String modifyPer;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 版本号
     */
    private Integer version;
    /**
      *  状态名称
      */
    private String statusName;


}
