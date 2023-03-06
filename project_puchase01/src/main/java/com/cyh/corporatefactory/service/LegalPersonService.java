package com.cyh.corporatefactory.service;

import com.cyh.util.ResultVo;

/**
 * @className: LegalPersonService
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 10:47
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface LegalPersonService {
    ResultVo getCurrentUser();

    ResultVo queryPlantListByLegalPersonCode(String legalPersonCode);
}
