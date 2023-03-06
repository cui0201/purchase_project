package com.cyh.spare.controller;

import com.cyh.spare.bean.SpareAdd;
import com.cyh.spare.bean.SpareQuery;
import com.cyh.spare.bean.SpareStatus;
import com.cyh.spare.bean.SpareUpdate;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.spare.service.SpareService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: SpareController
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 17:29
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "spare")
public class SpareController {

    @Autowired
    private SpareService spareService;


    @PostMapping("/queryPage")
    public ResultVo queryPage(@RequestBody SpareQuery spareQuery) {
        return spareService.queryPageByCondition(spareQuery);
    }

    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody SpareStatus spareStatus) {
        return spareService.updateStatus(spareStatus);
    }

    @GetMapping("/queryById")
    public ResultVo queryById(@RequestParam("id") Integer id) {
        return spareService.getLegalPerson(id);
    }

    @PostMapping("add")
    public ResultVo addSpare(@RequestBody SpareAdd spareAdd) {
        return spareService.AddSpare(spareAdd);
    }

    @PostMapping("/update")
    public ResultVo updateSpare(@RequestBody SpareUpdate spareUpdate) {
        return spareService.modifySpare(spareUpdate);
    }

    @GetMapping("/querySpareDropDownValue")
    public ResultVo querySpareDropDownValue(@RequestParam("legalPersonCode") String legalPersonCode) {
        return spareService.querySpareDropDownValue(legalPersonCode);
    }
    @GetMapping("/querySpareCodeByLegalPersonId")
    public ResultVo querySpareCodeByLegalPersonId(@RequestParam("legalPersonId")Integer legalPersonId){

        return spareService.querySpareCodeByLegalPersonId(legalPersonId);
    }
}
