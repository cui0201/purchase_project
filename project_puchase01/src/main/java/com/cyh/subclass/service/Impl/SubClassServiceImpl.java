package com.cyh.subclass.service.Impl;

import com.cyh.subclass.bean.*;
import com.cyh.subclass.mapper.SubClassMapper;
import com.cyh.subclass.service.SubClassService;
import com.cyh.util.PageInfo;
import com.cyh.util.ParamUtil;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @className: subClassServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/07 15:10
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class SubClassServiceImpl implements SubClassService {

    @Autowired
    private SubClassMapper subClassMapper;
    @Override
    public Integer getCountByCode(String code) {
        return subClassMapper.getCountByCode(code);
    }

    @Override
    public Integer getCountByName(String name) {
        return subClassMapper.getCountByName(name);
    }

    @Override
    public void insertDate(SubClassAdd subClassAdd) {
        SubClass subClass=new SubClass();
        BeanUtils.copyProperties(subClassAdd,subClass);
        subClass.setStatus(true);
        subClass.setCreateTime(new Date());
        subClass.setCreatePer("wangzi");
        subClass.setModifyPer("wangzi");
        subClass.setModifyTime(new Date());
        subClassMapper.insertDate(subClass);

    }

    @Override
    public ResultVo modifySubClass(SubClassModify subClassModify) {
        //根据主键查找数据
        SubClass subClass = subClassMapper.getSubClassById(subClassModify.getId());
        if (subClass.getStatus()) {

            ResultVo resultVo = ResultVoBuild.defeated("状态为启用，禁止修改！！！");
            return resultVo;
        } else {
            int nameCount = subClassMapper.getCountByNameId(subClassModify.getName(), subClassModify.getId());
            if (nameCount > 0) {
                ResultVo resultVo = ResultVoBuild.defeated("备件名称重复！！！！无法添加");
                return resultVo;
            } else {
                subClassModify.setModifyPer("小黑");
                subClassModify.setVersion(subClass.getVersion());
                subClassMapper.modifySubClass(subClassModify);
                return ResultVoBuild.success();
            }
        }
    }

    @Override
    public ResultVo querySubClassByCondition(SubClassPage subClassPage) {
        Integer startNum=(subClassPage.getPageIndex()-1)* subClassPage.getPageSize();
        Integer count=subClassMapper.getCountByCondition(subClassPage);
        List<SubClass> subClass = subClassMapper.querySubClassByCondition(startNum,subClassPage.getPageSize(),subClassPage);
        for (SubClass sub:subClass) {
            if(sub.getStatus()){
                sub.setStatusName("启用");
            }else{
                sub.setStatusName("禁用");
            }
        }
        PageInfo<SubClass> pageInfo = new PageInfo<>(subClassPage.getPageIndex(),subClassPage.getPageSize(),count,subClass,null,null,null);
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        resultVo.setData(pageInfo);
        return resultVo;


    }

    @Override
    public ResultVo modifyStatus(SubClassStatus subClassStatus) {
        subClassStatus.setModifyPer("晃晃");
        SubClass subClassById = subClassMapper.getSubClassById(subClassStatus.getId());
        subClassMapper.modifyStatus(subClassStatus);

        return ResultVoBuild.success();
    }


}
