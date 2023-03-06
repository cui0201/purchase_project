package com.cyh.corporatefactory.controller;

import com.cyh.corporatefactory.bean.LegalFactoryPage;
import com.cyh.corporatefactory.bean.LegalPlantAdd;
import com.cyh.corporatefactory.bean.LegalPlantStatus;
import com.cyh.corporatefactory.bean.LegalPlantUpdate;
import com.cyh.corporatefactory.service.CorporateFactoryService;
import com.cyh.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @className: CorporateFactoryController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:21
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("legalPlant")
public class CorporateFactoryController {
    @Autowired
    private CorporateFactoryService corporateFactoryService;

    @PostMapping("/query")
    public ResultVo query(@RequestBody LegalFactoryPage legalFactoryPage) {
        return corporateFactoryService.queryByCondition(legalFactoryPage);
    }

    @PostMapping("/add")
    public ResultVo add(@RequestBody LegalPlantAdd legalPlantAdd) {
        return corporateFactoryService.add(legalPlantAdd);
    }

    @PostMapping("/updatestatus")
    public ResultVo updateStatus(@RequestBody LegalPlantStatus legalPlantStatus) {

        return corporateFactoryService.updateStatus(legalPlantStatus);
    }

    @PostMapping("/update")
    public ResultVo updatePlant(@RequestBody LegalPlantUpdate legalPlantUpdate) {
        return corporateFactoryService.updateLegalPlant(legalPlantUpdate);
    }
}
