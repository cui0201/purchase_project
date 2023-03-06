package com.cyh.corporatefactory.service.Impl;

import com.cyh.corporatefactory.bean.*;
import com.cyh.corporatefactory.mapper.CorporateFactoryMapper;
import com.cyh.corporatefactory.service.CorporateFactoryService;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: CorporateFactoryServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/10 22:22
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class CorporateFactoryServiceImpl implements CorporateFactoryService {
    @Autowired
    private CorporateFactoryMapper corporateFactoryMapper;

    @Override
    public ResultVo queryByCondition(LegalFactoryPage legalFactoryPage) {
        Integer totalSize = corporateFactoryMapper.countByCondition(legalFactoryPage);
        Integer startNum = legalFactoryPage.getPageSize() * (legalFactoryPage.getPageIndex() - 1);
        List<LegalFactory> list = corporateFactoryMapper.queryByCondition(startNum, legalFactoryPage);
        PageInfo<LegalFactory> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        pageInfo.setCurrentPage(legalFactoryPage.getPageIndex());
        pageInfo.setTotalSize(totalSize);
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    public ResultVo add(LegalPlantAdd legalPlantAdd) {
        legalPlantAdd.setId(corporateFactoryMapper.getIdByLegalPer(legalPlantAdd.getLegalPersonCode()));
        legalPlantAdd.setModifyPer("添加人");
        legalPlantAdd.setCreatePer("添加人");
        corporateFactoryMapper.addLegalPlant(legalPlantAdd);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo updateStatus(LegalPlantStatus legalPlantStatus) {
        legalPlantStatus.setModifyPer("修改人");
        corporateFactoryMapper.updateStatus(legalPlantStatus);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo updateLegalPlant(LegalPlantUpdate legalPlantUpdate) {
        legalPlantUpdate.setModifyPer("修改人");
        corporateFactoryMapper.updateLegalPlant(legalPlantUpdate);
        return ResultVoBuild.success();
    }

}
