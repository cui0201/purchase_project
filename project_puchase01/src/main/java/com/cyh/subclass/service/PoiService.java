package com.cyh.subclass.service;

import com.cyh.util.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @className: PoiService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/01 17:36
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface PoiService {
    /**
     * 导入文件
     *
     * @param multipartFile
     * @return
     */
    ResultVo importFile(MultipartFile multipartFile) throws IOException;
}
