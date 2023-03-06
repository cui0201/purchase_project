package com.cyh.sparepartscost.controller;

import com.cyh.sparepartscost.bean.SparePartsCostForImportVo;
import com.cyh.sparepartscost.service.ImportService;
import com.cyh.util.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @className: ImportController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/06 09:58
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Controller
@ResponseBody
@Api(tags = "备件价格导入导出")
public class ImportController {
    @Resource
    private ImportService importService;

    @ApiOperation(value = "导入")
    @PostMapping("SparePartsCost/SparePartsCostIntroduction")
    public ResultVo importSpareCost( String legalPersonCode, String priceType, MultipartFile multipartFile) throws IOException {
        return importService.importSpareCost(legalPersonCode,priceType,multipartFile);
    }

}
