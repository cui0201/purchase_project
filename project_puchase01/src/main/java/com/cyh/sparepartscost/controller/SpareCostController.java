package com.cyh.sparepartscost.controller;

import com.cyh.sparepartscost.bean.PriceCostAdd;
import com.cyh.sparepartscost.bean.PriceCostPage;
import com.cyh.sparepartscost.bean.PriceCostStatus;
import com.cyh.sparepartscost.bean.PriceCostUpdate;
import com.cyh.sparepartscost.mapper.SpareCostMapper;
import com.cyh.sparepartscost.service.SpareCostService;
import com.cyh.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: SpareCostController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/22 13:59
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@RequestMapping("priceCost")
public class SpareCostController {
    @Autowired
    private SpareCostService spareCostService;

    @PostMapping("getPullDownList")
    public ResultVo getPullDownList() {
        return spareCostService.getPullDownList();
    }

    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody PriceCostPage priceCostPage) {
        return spareCostService.queryPage(priceCostPage);
    }

    @PostMapping("add")
    public ResultVo addSpareCost(@RequestBody PriceCostAdd priceCostAdd) {
        return spareCostService.addSpareCost(priceCostAdd);
    }
    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody PriceCostStatus priceCostStatus){
        return spareCostService.updatePriceCostStatus(priceCostStatus);
    }
    @PostMapping("update")
    public ResultVo updateSpareCost(@RequestBody PriceCostUpdate priceCostUpdate){
        return spareCostService.updatePriceCost(priceCostUpdate);
    }

}
