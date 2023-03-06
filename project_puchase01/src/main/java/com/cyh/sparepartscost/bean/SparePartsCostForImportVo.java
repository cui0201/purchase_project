package com.cyh.sparepartscost.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: SparePartsCostForImportVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/02 11:31
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class SparePartsCostForImportVo {
    /**
     * 法人编码
     */
    private String legalPersonCode;
    /**
     * 价格类型编码
     */
    private String priceType;
    /**
      *  导入.xlsx文件
      */
    private MultipartFile multipartFile;
}
