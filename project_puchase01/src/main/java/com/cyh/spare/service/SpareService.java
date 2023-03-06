package com.cyh.spare.service;

import com.cyh.spare.bean.SpareAdd;
import com.cyh.spare.bean.SpareQuery;
import com.cyh.spare.bean.SpareStatus;
import com.cyh.spare.bean.SpareUpdate;
import com.cyh.util.ResultVo;

/**
 * @className: SpareService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:56
 * @Company: Copyright© [日期] by [作者或个人]
 **/

public interface SpareService {
    ResultVo queryPageByCondition(SpareQuery spareQuery);

    ResultVo updateStatus(SpareStatus spareStatus);

    ResultVo AddSpare(SpareAdd spareAdd);

    ResultVo getLegalPerson(Integer id);

    ResultVo modifySpare(SpareUpdate spareUpdate);

    ResultVo querySpareDropDownValue(String legalPersonCode);

    ResultVo querySpareCodeByLegalPersonId(Integer legalPersonId);
}
