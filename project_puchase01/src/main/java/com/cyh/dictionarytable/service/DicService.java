package com.cyh.dictionarytable.service;

import com.cyh.dictionarytable.model.Dictionary;
import com.cyh.dictionarytable.model.DictionaryUpdate;
import com.cyh.util.ResultVo;

/**
 * @className: DicService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/28 15:19
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface DicService {
    /**
     * 添加父类字典数据
     *
     * @param dictionary
     * @return ResultVo
     */
    ResultVo insertParent(Dictionary dictionary);

    /**
     * 添加子类数据字典
     *
     * @param dictionary
     * @return ResultVo
     */
    ResultVo insertSon(Dictionary dictionary);

    /**
     * 查询全部数据
     *
     * @return
     */
    ResultVo queryAll();

    /**
     * 修改状态
     *
     * @param dictionaryUpdate
     * @return
     */
    ResultVo updateStatus(DictionaryUpdate dictionaryUpdate);
}
