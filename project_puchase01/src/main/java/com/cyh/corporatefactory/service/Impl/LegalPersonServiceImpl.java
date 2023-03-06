package com.cyh.corporatefactory.service.Impl;

import com.cyh.corporatefactory.bean.LegalFactory;
import com.cyh.corporatefactory.bean.LegalPer;
import com.cyh.corporatefactory.mapper.CorporateFactoryMapper;
import com.cyh.corporatefactory.service.LegalPersonService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.ReadableByteChannel;
import java.util.List;

/**
 * @className: LegalPersonServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/11 10:47
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class LegalPersonServiceImpl implements LegalPersonService {

    @Autowired
    private CorporateFactoryMapper corporateFactoryMapper;

    @Override
    public ResultVo getCurrentUser() {
        List<LegalPer> legalPers = corporateFactoryMapper.queryLegalPer();

        return ResultVoBuild.success(legalPers);
    }

    @Override
    public ResultVo queryPlantListByLegalPersonCode(String legalPersonCode) {
        List<LegalFactory> legalFactoryList = corporateFactoryMapper.queryPlantListByLegalPersonCode(legalPersonCode);
        return ResultVoBuild.success(legalFactoryList);
    }
}
