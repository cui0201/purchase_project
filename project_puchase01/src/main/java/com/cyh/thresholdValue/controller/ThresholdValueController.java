package com.cyh.thresholdValue.controller;

import com.cyh.thresholdValue.bean.ThresholdValueAdd;
import com.cyh.thresholdValue.bean.ThresholdValuePage;
import com.cyh.thresholdValue.bean.ThresholdValueUpdate;
import com.cyh.thresholdValue.service.ThresholdValueService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

/**
 * @className: ThresholdValueController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/17 14:28
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@RequestMapping("/thresholdValue")
public class ThresholdValueController {
    @Autowired
    private ThresholdValueService thresholdValueService;

    @PostMapping("/query")
    public ResultVo queryAll(@RequestBody @Valid ThresholdValuePage thresholdValuePage, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVoBuild.defeated(bindingResult.getFieldError().getDefaultMessage());
        }
        return thresholdValueService.queryAll(thresholdValuePage);
    }
    @PostMapping("/add")
    public ResultVo add(@RequestBody @Valid ThresholdValueAdd thresholdValueAdd, BindingResult bindingResult){
        if(bindingResult.hasGlobalErrors()){
            return ResultVoBuild.defeated(bindingResult.getFieldError().getDefaultMessage());
        }
        return thresholdValueService.add(thresholdValueAdd);
    }
    @PostMapping("/update")
    public ResultVo update(@RequestBody ThresholdValueUpdate thresholdValueUpdate){
        return thresholdValueService.update(thresholdValueUpdate);
    }

}
