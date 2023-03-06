package com.cyh.sparepartscost.controller;

import com.cyh.sparepartscost.bean.SparePartsCostForImportVo;
import com.cyh.sparepartscost.service.SparePartsCostService;
import com.cyh.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @className: SparePartsCostController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/02 11:19
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@Api(tags = "备件价格导入接口")
public class SparePartsCostController {
    @Resource
    private SparePartsCostService sparePartsCostService;

    @ApiOperation(value = "备件导入！！")
    @Options
    public ResultVo sparePortsCostImport(@RequestBody SparePartsCostForImportVo sparePartsCostForImportVo){
        return sparePartsCostService.sparePortsCostImport(sparePartsCostForImportVo);

    }

}
