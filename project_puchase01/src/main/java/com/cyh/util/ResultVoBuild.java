package com.cyh.util;

import com.cyh.subclass.bean.SubClass;
import com.cyh.subclass.bean.SubClassAdd;
import lombok.Data;

/**
 * @className: ResultVoBuild
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 16:29
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ResultVoBuild {


    public static ResultVo defeated(String errorMessage){
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(false);
        resultVo.setErrorMessage(errorMessage);
        return resultVo;
    }
    public static ResultVo success(){
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        return resultVo;
    }
    public static<T> ResultVo success(T data){
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return resultVo;
    }
}
