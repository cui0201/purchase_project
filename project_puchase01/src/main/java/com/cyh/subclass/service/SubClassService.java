package com.cyh.subclass.service;

import com.cyh.subclass.bean.SubClassAdd;
import com.cyh.subclass.bean.SubClassModify;
import com.cyh.subclass.bean.SubClassPage;
import com.cyh.subclass.bean.SubClassStatus;
import com.cyh.util.ResultVo;

/**
 * @className: subClassService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 15:09
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface SubClassService {
    Integer getCountByCode(String code);

    Integer getCountByName(String name);

    void insertDate(SubClassAdd subClassAdd);

    ResultVo modifySubClass(SubClassModify subClassModify);

    ResultVo querySubClassByCondition(SubClassPage subClassPage);

    ResultVo modifyStatus(SubClassStatus subClassStatus);
}
