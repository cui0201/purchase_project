package com.cyh.Tax.controller;

import com.cyh.Tax.bean.TaxAddVo;
import com.cyh.Tax.bean.TaxPage;
import com.cyh.Tax.bean.TaxUpdateVo;
import com.cyh.Tax.service.TaxService;
import com.cyh.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @className: TaxController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/21 15:19
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Controller
@RestController
@CrossOrigin
@RequestMapping("/tax")
public class TaxController {
    @Autowired
    private TaxService taxService;

    @PostMapping("/queryPage")
    public ResultVo queryPage(@RequestBody TaxPage taxPage) {
        return taxService.queryPageByConditionForPage(taxPage);
    }
    @PostMapping("/save")
    public ResultVo addTax(@RequestBody TaxAddVo taxAddVo){
        return taxService.addTax(taxAddVo);
    }
    @PostMapping("/update")
    public ResultVo updateTax(@RequestBody TaxUpdateVo taxUpdateVo){
        return taxService.updateTax(taxUpdateVo);
    }
    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody TaxAddVo TaxAddVo){
        return taxService.updateStatus(TaxAddVo);
    }
    @GetMapping("/queryAllTaxType")
    public ResultVo queryAllTaxType(){
        return taxService.queryAllTaxType();
    }
}

