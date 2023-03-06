package com.cyh.sparepartscost.service;

import com.cyh.sparepartscost.bean.SparePartsCostForImportVo;
import com.cyh.util.ResultVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: SparePartsCostServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/02 11:20
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface SparePartsCostService {
    /**
     * 备件价格导入
     * @param sparePartsCostForImportVo
     * @return
     */
    ResultVo sparePortsCostImport(SparePartsCostForImportVo sparePartsCostForImportVo);
}
