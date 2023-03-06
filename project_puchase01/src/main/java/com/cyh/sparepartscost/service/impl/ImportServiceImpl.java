package com.cyh.sparepartscost.service.impl;

import com.cyh.sparepartscost.bean.ImportModel;
import com.cyh.sparepartscost.bean.SparePartsCostForImportVo;
import com.cyh.sparepartscost.bean.SparePartsCostVo;
import com.cyh.sparepartscost.service.ImportService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cyh.util.ParamUtil.*;

/**
 * @className: ImportServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/06 09:59
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class ImportServiceImpl implements ImportService {

    @Override
    public ResultVo importSpareCost(String legalPersonCode, String priceType, MultipartFile multipartFile) throws IOException {
        //验证后缀名是否正确
        if (!multipartFile.getOriginalFilename().endsWith(FILE_SUFFIX)) {
            ResultVoBuild.defeated(ERROR_IMPORT_TYPE);
        }
        //转换文件类型
        XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
        //获取sheets：为第一个
        XSSFSheet sheet = sheets.getSheetAt(0);
        //验证sheet的第一行标题是否是我们所需要的
        String title = sheet.getRow(0).getCell(0).getStringCellValue();
        if (!title.equals(TITLE_NAME_SPARE_COST)) {
            ResultVoBuild.defeated(ERROR_IMPORT_NAME);
        }
        List<ImportModel> importModels = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = START_ROW_NUM; i <= sheet.getPhysicalNumberOfRows(); i++) {
            ImportModel importModel = new ImportModel();
            try {

                importModel.setLegalPersonCode(legalPersonCode);
                importModel.setPriceType(priceType);
                String spareCode = sheet.getRow(i).getCell(1).getStringCellValue();
                importModel.setSpareCode(spareCode);
                String spareName = sheet.getRow(i).getCell(2).getStringCellValue();
                importModel.setSpareName(spareName);
                String taxCode = sheet.getRow(i).getCell(3).getStringCellValue();
                importModel.setTaxCode(taxCode);
                Double sparePrice = sheet.getRow(i).getCell(4).getNumericCellValue();
                importModel.setSparePrice(BigDecimal.valueOf(sparePrice));
                Date startTime = sheet.getRow(i).getCell(5).getDateCellValue();
                importModel.setStartTime(startTime);
                Date endTime = sheet.getRow(i).getCell(6).getDateCellValue();
                importModel.setEndTime(endTime);
                importModels.add(importModel);

            }catch (Exception e){
                stringBuilder.append("第"+i+"行非空值为空，请修改后重新导入！！");
            }
        }
        if(!stringBuilder.isEmpty()){
            return ResultVoBuild.defeated(String.valueOf(stringBuilder));
        }
        return ResultVoBuild.success(importModels);
    }

}
