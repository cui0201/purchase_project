package com.cyh.subclass.controller;

import com.cyh.subclass.service.PoiService;
import com.cyh.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.IOException;

/**
 * @className: POIController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/01 17:27
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Api(tags = "导入导出功能！")
@Controller
@ResponseBody
public class PoiController {
    @Resource
    private PoiService poiService;


    @ApiOperation(value = "导入")
    @PostMapping("/importFile")
    public ResultVo importFile(MultipartFile multipartFile) throws IOException {
        return poiService.importFile(multipartFile);


    }
}
