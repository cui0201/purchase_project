package com.cyh.sparepartscost.mapper;

import com.cyh.sparepartscost.bean.*;
import com.cyh.sparepartscost.bean.update.PriceCostUpdateForText;
import com.cyh.sparepartscost.bean.update.PriceCostUpdateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @className: SpareCostMapper
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:00
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Mapper
public interface SpareCostMapper {
    /**
     * 查询价格分类
     *
     * @param
     * @return List<PriceType>
     */
    List<PriceType> getPriceTypeList();

    /**
     * 查询币别
     *
     * @param
     * @return List<Currency>
     */
    List<Currency> getCurrencyList();

    /**
     * 根据条件查询分页总条数
     *
     * @param priceCostPage
     * @return Integer
     */
    Integer getTotalSizeByCondition(PriceCostPage priceCostPage);

    /**
     * 条件查询分页数据
     *
     * @param priceCostPage
     * @return List<PriceCostPageVo>
     */
    List<PriceCostPageVo> queryListForPage(PriceCostPage priceCostPage);

    /**
     * 添加备件价格
     *
     * @param priceCostAdd
     * @return
     */
    Boolean insertSpareCost(PriceCostAdd priceCostAdd);

    /**
     * 修改备件价格状态
     *
     * @param priceCostStatus
     * @return java.lang.Boolean
     */
    Boolean updatePriceCostStatus(PriceCostStatus priceCostStatus);

    /**
     * 查询添加备件价格是否有相同的备件价格：除了价格以及时间
     *
     * @param priceCostAdd
     * @return
     */
    List<PriceCostForAdd> getPriceCostForAdd(PriceCostAdd priceCostAdd);

    /**
     * 添加操作：
     * 如果开始时间相同，则以最新提交的覆盖原有的
     *
     * @param priceCostAdd
     * @return
     */
    Boolean updatePriceCost(PriceCostAdd priceCostAdd);

    /**
     * 添加操作：
     * 如果开始时间不同，但是增加的备件小类的备件价格相同
     * 则只需要修改结束时间，延长备件价格使用时间
     *
     * @param priceCostAdd
     */
    void updatePriceCostEndTime(PriceCostAdd priceCostAdd);

    /**
     * 添加操作：
     * 2.2若添加的备件价格与原本的备件价格不相同
     *  将较早的数据结束时间自动变更为较晚数据的开始时间前一天
     *
     * @param id
     * @param newDate
     */
    void updatePriceCostEndTimeForNewDate(@Param("id") Integer id, @Param("newDate") Date newDate);

    /**
     * 根据id查找备件价格信息
     * @param id
     * @return PriceCostUpdateForText
     */
    PriceCostUpdateForText getPriceCostById(@Param("id")Integer id);

    /**
     * 添加:
     * 根据id修改开始时间
     * @param priceCostAdd
     */
    void updatePriceCOstStartTimeById(PriceCostAdd priceCostAdd);


    /**
     * 添加：
     * 查询所有相同的备件价格信息
     * @param priceCostUpdateForText
     * @return
     */
    List<PriceCostUpdateVo> selectAllByPriceCost(PriceCostUpdateForText priceCostUpdateForText);

    /**
     * 修改：
     * 时间没有发生冲突，直接修改
     * @param priceCostUpdate
     */
    void updatePriceCostEndTimeForUpdate(PriceCostUpdate priceCostUpdate);

    /**
     * 修改：
     * 修改的结束时间早于数据库中的结束时间
     * @param id
     * @param oldStartTime
     */
    void updatePriceCostStartTimeByIdForOld(@Param("id") Integer id,@Param("oldStartTime") Date oldStartTime);

    /**
     * 根据id删除原来数据库中的数据
     * @param id
     */
    void deletePriceCost(@Param("id") Integer id);

    /**
     * 修改历史数据的开始时间，根据id修改
     * @param id
     * @param startTime
     */
    void updatePriceCostStartTimeById(@Param("id") Integer id, @Param("startTime") Date startTime);

    /**
     * 根据id查询历史数据的全部信息
     * @param id
     * @return
     */
    PriceCostAdd getAllById(Integer id);
}
