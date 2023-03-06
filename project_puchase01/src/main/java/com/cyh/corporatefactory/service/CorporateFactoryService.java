package com.cyh.corporatefactory.service;

import com.cyh.corporatefactory.bean.LegalFactoryPage;
import com.cyh.corporatefactory.bean.LegalPlantAdd;
import com.cyh.corporatefactory.bean.LegalPlantStatus;
import com.cyh.corporatefactory.bean.LegalPlantUpdate;
import com.cyh.util.ResultVo;

/**
 * @className: CorporateFactoryservice
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:22
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public interface CorporateFactoryService {
    ResultVo queryByCondition(LegalFactoryPage legalFactoryPage);

    ResultVo add(LegalPlantAdd legalPlantAdd);

    ResultVo updateStatus(LegalPlantStatus legalPlantStatus);

    ResultVo updateLegalPlant(LegalPlantUpdate legalPlantUpdate);
}
