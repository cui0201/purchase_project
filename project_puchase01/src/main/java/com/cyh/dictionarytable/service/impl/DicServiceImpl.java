package com.cyh.dictionarytable.service.impl;

import cn.hutool.core.lang.Dict;
import com.cyh.dictionarytable.mapper.DicMapper;
import com.cyh.dictionarytable.model.Dictionary;
import com.cyh.dictionarytable.model.DictionaryUpdate;
import com.cyh.dictionarytable.service.DicService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: DisSerciveImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 15:20
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class DicServiceImpl implements DicService {
    @Autowired
    private DicMapper dicMapper;

    @Override
    public ResultVo insertParent(Dictionary dictionary) {
        Boolean result = dicMapper.insert(dictionary);
        //验证名称或者编码是否存在
        Integer noNull = dicMapper.queryForNameAndCode(dictionary);
        if(noNull>0) {
            return ResultVoBuild.defeated("名称或者编码已经存在，请修改后重新尝试");
        }


            return ResultVoBuild.success();

    }

    @Override
    public ResultVo insertSon(Dictionary dictionary) {
        Boolean result = dicMapper.insert(dictionary);
        //验证名称或者编码是否存在
        Integer noNull = dicMapper.queryForNameAndCode(dictionary);
        if(noNull>0){
            return ResultVoBuild.defeated("名称或者编码已经存在，请修改");
        }
        if (result) {
            return ResultVoBuild.success();
        }
        return ResultVoBuild.defeated("添加子类字典失败");
    }

    @Override
    public ResultVo queryAll() {
        Map<String, List<Dictionary>> listMap = new HashMap<>(20);
        //查询全部信息
        List<Dictionary> list = dicMapper.queryALl();
        for (Dictionary li : list) {
            String s = new String();
            if (li.getType() == 0) {
                s = li.getCode();
            }
            List<Dictionary> list1 = new ArrayList<>();
            for (Dictionary a : list) {
                if (s.equals(a.getParentCode())) {
                    list1.add(a);
                }
            }
            listMap.put(s, list1);
        }
        return ResultVoBuild.success(listMap);

    }

    @Override
    public ResultVo updateStatus(DictionaryUpdate dictionaryUpdate) {
        //判断修改的是否为父类
        Dictionary dictionary = dicMapper.queryTypeByCode(dictionaryUpdate.getCode());
        if (dictionary.getType() == 0) {
            //修改父类中的全部状态
            dicMapper.updateStatus(dictionaryUpdate);
        }

        //统计启用的是否大于零
        Integer countStatusFalse=dicMapper.countStatusFalse(dictionary);
        if(countStatusFalse>0){
            dicMapper.updateStatusSon(dictionaryUpdate);
        }else {
            dicMapper.updateStatus(dictionaryUpdate);
        }
        return ResultVoBuild.success();
    }
}
