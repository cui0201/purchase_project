package com.cyh.dictionarytable.controller;

import com.cyh.dictionarytable.model.Dictionary;
import com.cyh.dictionarytable.model.DictionaryUpdate;
import com.cyh.dictionarytable.service.DicService;
import com.cyh.util.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: DicController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 15:05
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Controller
@ResponseBody
@Api(tags = "字典接口")
public class DicController {
    @Autowired
    private DicService dicService;

    @ApiOperation(value = "添加父类")
    @PostMapping("/insertParent")
    public ResultVo insertParent(@RequestBody Dictionary dictionary){

        return dicService.insertParent(dictionary);
    }
    @ApiOperation(value = "添加子类")
    @PostMapping("/insertSon")
    public ResultVo insertSon(@RequestBody Dictionary dictionary){
        return dicService.insertSon(dictionary);
    }
    @ApiOperation(value = "查询全部父类子类")
    @PostMapping("/queryALl")
    public ResultVo queryAll(){
        return dicService.queryAll();
    }
    @ApiOperation(value = "修改状态")
    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody DictionaryUpdate dictionaryUpdate){
        return dicService.updateStatus(dictionaryUpdate);
    }
}
