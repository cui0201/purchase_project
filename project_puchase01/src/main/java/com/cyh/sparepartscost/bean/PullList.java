package com.cyh.sparepartscost.bean;

import lombok.Data;

import java.util.List;

/**
 * @className: PullList
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 14:46
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Data
public class PullList {
    private List<Status> statusList;
    private List<Currency> currencyList;
    private List<PriceType> priceTypeList;
}
