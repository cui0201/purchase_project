package com.cyh.thresholdValue.mapper;

import com.cyh.thresholdValue.bean.ThresholdValueAdd;
import com.cyh.thresholdValue.bean.ThresholdValuePage;
import com.cyh.thresholdValue.bean.ThresholdValuePageVo;
import com.cyh.thresholdValue.bean.ThresholdValueUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: ThreshpldValueMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/17 14:43
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface ThresholdValueMapper {
    /**
     * @param thresholdValuePage
     * @return java.lang.Integer
     * @description:计算分页总条数
     */
    Integer countTotalPageSize(ThresholdValuePage thresholdValuePage);

    List<ThresholdValuePageVo> queryAllForList(ThresholdValuePage thresholdValuePage);

    Boolean addThresholdValue(ThresholdValueAdd thresholdValueAdd);

    Boolean updateThresholdValue(ThresholdValueUpdate thresholdValueUpdate);
}
