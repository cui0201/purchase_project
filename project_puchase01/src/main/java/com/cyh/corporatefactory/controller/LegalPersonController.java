package com.cyh.corporatefactory.controller;

import com.cyh.corporatefactory.service.LegalPersonService;
import com.cyh.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @className: LegalPersonController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 10:45
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Controller
@ResponseBody
@CrossOrigin
public class LegalPersonController {

    @Autowired
    private LegalPersonService legalPersonService;

    @GetMapping("/legalPerson/ofCurrentUser")
    public ResultVo CurrentUser(){
        return legalPersonService.getCurrentUser();
    }

    @GetMapping("legalPlant/queryPlantListByLegalPersonCode")
    public ResultVo queryPlantListByLegalPersonCode(@RequestParam("legalPersonCode") String legalPersonCode){
        return legalPersonService.queryPlantListByLegalPersonCode(legalPersonCode);


    }


}
