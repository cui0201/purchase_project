package com.cyh.spare.service.Impl;

import com.cyh.corporatefactory.bean.LegalPer;
import com.cyh.plancategory.mapper.PlanCategoryMapper;
import com.cyh.spare.bean.*;
import com.cyh.spare.mapper.SpareMapper;
import com.cyh.spare.service.SpareService;
import com.cyh.subclass.mapper.SubClassMapper;
import com.cyh.util.PageInfo;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @className: SpareServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/02/13 21:56
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
@Transactional
public class SpareServiceImpl implements SpareService {
    @Autowired
    private SpareMapper spareMapper;
    @Autowired
    private SubClassMapper subClassMapper;
    @Autowired
    private PlanCategoryMapper planCategoryMapper;

    @Override
    public ResultVo queryPageByCondition(SpareQuery spareQuery) {
        Integer totalSize = spareMapper.getCountByCondition(spareQuery);
        Integer startNum = spareQuery.getPageSize() * (spareQuery.getPageIndex() - 1);
        List<SpareQueryAllArg> list = spareMapper.getAllByCondition(startNum, spareQuery);
        List<Object> legalPages = new ArrayList<>();
        for (SpareQueryAllArg s : list) {
            legalPages.add(s.getId());
        }
        if (!CollectionUtils.isEmpty(list)) {
            List<SpareLegalPersonPage> personPage = spareMapper.getAllLegalPerson(legalPages);

            StringBuilder a;
            for (SpareQueryAllArg sp : list) {
                a = new StringBuilder();
                for (SpareLegalPersonPage lp : personPage) {
                    if (sp.getId().equals(lp.getSpareId())) {
                        a.append(lp.getLegalPersonName()).append(",");
                    }
                }
                if (a.length() != 0) {
                    a.substring(0, a.length() - 1);
                }

                sp.setLegalPersonName(String.valueOf(a));
                if (sp.getStatus()) {
                    sp.setStatusName("启用");
                } else {
                    sp.setStatusName("禁用");
                }

            }
        }
        PageInfo<SpareQueryAllArg> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        pageInfo.setCurrentPage(spareQuery.getPageIndex());
        pageInfo.setPageSize(spareQuery.getPageSize());
        pageInfo.setTotalSize(totalSize);
        return ResultVoBuild.success(pageInfo);
    }

    @Override
    public ResultVo updateStatus(SpareStatus spareStatus) {
        spareStatus.setModifyPer("修改人");
        spareMapper.updateStatus(spareStatus);
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo AddSpare(SpareAdd spareAdd) {
        Integer subCount = subClassMapper.getSubCountById(spareAdd.getSubClassId());
        Integer planCount = planCategoryMapper.getPlanCountById(spareAdd.getPlanClassId());
        if (subCount <= 0) {
            return ResultVoBuild.defeated("备件小类不存在，请重新修改");
        } else if (planCount <= 0) {
            return ResultVoBuild.defeated("计划大类不存在，请重新修改！");
        }
        spareAdd.setCreatePer("创建人");
        spareAdd.setModifyPer("创建人");
        spareMapper.AddSpare(spareAdd);
        if (spareAdd.getLegalPersonIds().size() != 0) {
            Integer id = spareAdd.getId();
            spareMapper.AddSpareLegal(id, spareAdd.getLegalPersonIds());
        }
        return ResultVoBuild.success();

    }

    @Override
    public ResultVo getLegalPerson(Integer id) {
        List<LegalPer> legalPerList = spareMapper.getLegalPerson(id);
        return ResultVoBuild.success(legalPerList);
    }

    @Override
    public ResultVo modifySpare(SpareUpdate spareUpdate) {
        Integer subCount = subClassMapper.getSubCountById(spareUpdate.getSubClassId());
        Integer planCount = planCategoryMapper.getPlanCountById(spareUpdate.getPlanClassId());
        if (subCount <= 0) {
            return ResultVoBuild.defeated("备件小类不存在，请重新修改");
        } else if (planCount <= 0) {
            return ResultVoBuild.defeated("计划大类不存在，请重新修改！");
        }
        spareUpdate.setModifyPer("修改人");
        spareUpdate.setCreatePer("修改人");
        spareMapper.modifySpare(spareUpdate);
        //删除所有的备件id和对应的法人id
        spareMapper.deleteSpare(spareUpdate.getId());
        if (!CollectionUtils.isEmpty(spareUpdate.getLegalPersonId())) {
            spareMapper.AddSpareLegal(spareUpdate.getId(), spareUpdate.getLegalPersonId());
        }
        return ResultVoBuild.success();
    }

    @Override
    public ResultVo querySpareDropDownValue(String legalPersonCode) {
        List<SpareSubclass> legalPersonId = spareMapper.getPersonIdByCode(legalPersonCode);
        return ResultVoBuild.success(legalPersonId);
    }

    @Override
    public ResultVo querySpareCodeByLegalPersonId(Integer legalPersonId) {
        List<SpareForThresholdValue> spareList = spareMapper.getSpareByLegalPerson(legalPersonId);
        return ResultVoBuild.success(spareList);

    }


}
