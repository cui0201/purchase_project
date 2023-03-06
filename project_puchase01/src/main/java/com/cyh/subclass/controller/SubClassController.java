package com.cyh.subclass.controller;

import com.cyh.subclass.bean.SubClassAdd;
import com.cyh.subclass.bean.SubClassModify;
import com.cyh.subclass.bean.SubClassPage;
import com.cyh.subclass.bean.SubClassStatus;
import com.cyh.subclass.service.SubClassService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

/**
 * @className: subclassController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 15:08
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@RequestMapping("subClass")
@CrossOrigin //允许跨域
public class SubClassController {
    @Autowired
    private SubClassService subClassService;

    /**
            * @param subClassAdd
	* @param bindingResult
            * @return com.cyh.util.ResultVo
            * @description:添加备件小类
            */
    @PostMapping("/addSubClass")
    public ResultVo addSubClass(@RequestBody @Valid SubClassAdd subClassAdd, BindingResult bindingResult){
        //1,验证数据不能为空
        if(bindingResult.hasErrors()){
            return ResultVoBuild.defeated(bindingResult.getFieldError().getDefaultMessage());
        }
        //2.1 验证数据是否重复，编码和名称
        Integer codeCount=subClassService.getCountByCode(subClassAdd.getCode());
        if (codeCount>0){
            return ResultVoBuild.defeated("编码重复，尝试其他编码！！");
        }
        Integer nameCount= subClassService.getCountByName(subClassAdd.getName());
        if (nameCount>0){
            return ResultVoBuild.defeated("名称重复，请尝试其他名称！！");
        }

        subClassService.insertDate(subClassAdd);
        return ResultVoBuild.success();
    }
    /**
            * @param subClassModify
	* @param bindingResult
            * @return com.cyh.util.ResultVo
            * @description:修改备件小类
            */
    @PostMapping("/modifySubClass")
    public ResultVo updateSubClass(@RequestBody @Valid SubClassModify subClassModify,BindingResult bindingResult){
        //验证数据是否为空
        if(bindingResult.hasErrors()){
            //返回验证信息
            return ResultVoBuild.defeated(bindingResult.getFieldError().getDefaultMessage());
        }
        ResultVo resultVo = subClassService.modifySubClass(subClassModify);
        return resultVo;
    }
    @PostMapping("/updateStatus")
    public ResultVo modifyStatus(@RequestBody SubClassStatus subClassStatus){
       ResultVo resultVo=subClassService.modifyStatus(subClassStatus);
       return resultVo;
    }

    /**
            * @param subClassPage
            * @return com.cyh.util.ResultVo
            * @description:根据条件查新备件小类进行分页
            */
    @PostMapping("/queryPage")
    public ResultVo querySubClassByCondition(@RequestBody SubClassPage subClassPage){
        return subClassService.querySubClassByCondition(subClassPage);

    }
}
