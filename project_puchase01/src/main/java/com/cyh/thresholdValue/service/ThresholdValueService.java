package com.cyh.thresholdValue.service;

import com.cyh.thresholdValue.bean.ThresholdValueAdd;
import com.cyh.thresholdValue.bean.ThresholdValuePage;
import com.cyh.thresholdValue.bean.ThresholdValueUpdate;
import com.cyh.util.ResultVo;



/**
 * @className: ThresholdValueService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/17 14:41
 * @Company: Copyright© [日期] by [作者或个人]
 **/

public interface ThresholdValueService {
    /**
     * @param thresholdValuePage
     * @return com.cyh.util.ResultVo
     * @description:查找全部阈值设置展示在返回给前端
     */
    ResultVo queryAll(ThresholdValuePage thresholdValuePage);

    ResultVo add(ThresholdValueAdd thresholdValueAdd);

    ResultVo update(ThresholdValueUpdate thresholdValueUpdate);
}
