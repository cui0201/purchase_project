package com.cyh.sparepartscost.service;

import com.cyh.sparepartscost.bean.SparePartsCostForImportVo;
import com.cyh.util.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @className: ImportService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/06 09:58
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface ImportService {
    /**
     * 导出操作
     * @param legalPersonCode
     * @param priceType
     * @param multipartFile
     * @return
     * @throws IOException
     */
    ResultVo importSpareCost(String legalPersonCode, String priceType, MultipartFile multipartFile) throws IOException;
}
