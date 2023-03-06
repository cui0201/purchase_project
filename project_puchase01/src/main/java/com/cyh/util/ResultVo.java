package com.cyh.util;

import lombok.Data;

/**
 * @className: ResultVo
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 16:24
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class ResultVo<T> {
    //状态，true，false
    private Boolean success;
    //错误消息提示
    private String ErrorMessage;
    //传输数据
    private T Data;
}
