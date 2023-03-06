package com.cyh.subclass.controller;

import com.cyh.subclass.bean.StatusVo;


import com.cyh.subclass.service.SubClassService;
import com.cyh.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import com.cyh.util.ResultVoBuild;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: StatusController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/09 15:42
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@ResponseBody
@Controller
@CrossOrigin
public class StatusController {

    @PostMapping("/metadata/getPullDownList")
    public ResultVo getPullDownList(){
        List<StatusVo> statusVos = new ArrayList<>();
        statusVos.add(new StatusVo("启用",1));
        statusVos.add(new StatusVo("禁用",0));
        statusVos.add(new StatusVo("全部",null));
        return ResultVoBuild.success(statusVos);

    }
}
