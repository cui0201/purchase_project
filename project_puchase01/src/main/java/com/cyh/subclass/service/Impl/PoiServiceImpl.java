package com.cyh.subclass.service.Impl;


import cn.hutool.core.util.StrUtil;
import com.cyh.subclass.bean.SubClass;
import com.cyh.subclass.mapper.SubClassMapper;
import com.cyh.subclass.method.PoiMethod;
import com.cyh.subclass.service.PoiService;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

import static com.cyh.util.ParamUtil.*;

/**
 * @className: PoiServiceImpl
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/01 17:37
 * @Company: Copyright© [日期] by [作者或个人]
 **/
@Service
public class PoiServiceImpl extends PoiMethod implements PoiService {

    /**
     * 将许多方法抽离出来减少业务层代码：
     *  1.验证版本 2007
     *  2.验证是不是正确的模板-读取里面的内容，poi读取
     *  3.读取其中的数据放到java对象-poi读取内容
     *  4.一系列的验证：1.不为空字段是否为空
     *  5.长度验证
     * 6.重复验证 :输出哪一行 出现重复，
     * 7.数据转换，把汉字转换成数据库的值，状态必须填启用，禁用
     * 8.唯一性验证，编码  名称
     * * 9.批量入库
     */

    @Resource
    private SubClassMapper subClassMapper;
    @Override
    public ResultVo importFile(MultipartFile multipartFile) throws IOException {
        //判断后缀名是否为.xlsx版本的excel文件
        boolean equals = multipartFile.getOriginalFilename().endsWith(FILE_SUFFIX);
        if (!equals){
            return ResultVoBuild.defeated(ERROR_IMPORT_NAME);
        }


        //将传输的文件转化为xlsx
        XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
        //获取第一列第一行标题是否是我们需要的标题
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        String cell = sheetAt.getRow(0).getCell(0).getStringCellValue();
        if (!cell.equals(TITLE_NAME)) {
            return ResultVoBuild.defeated(ERROR_IMPORT_NAME);
        }
        //接收导入的数据
        List<SubClass> subClassList = subClassMapper.querySubClass();
        List<SubClass> subClasses = new ArrayList<>();
        for (int i = START_ROW_NUM; i <= sheetAt.getLastRowNum(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=START_CELL_NUM;j<CELL_NUM;j++) {
                ResultVo success = IsCellNull(sheetAt, i, j);
                if(!success.getSuccess()){
                    stringBuilder.append(success);
                }
            }
            if (!StrUtil.isEmpty(stringBuilder)){
                return ResultVoBuild.defeated(String.valueOf(stringBuilder));
            }
            String code = sheetAt.getRow(i).getCell(1).getStringCellValue();
            String name = sheetAt.getRow(i).getCell(2).getStringCellValue();
            String statusName = sheetAt.getRow(i).getCell(3).getStringCellValue();
            SubClass subClass = new SubClass();
            subClass.setCode(code);
            subClass.setName(name);
            subClass.setStatusName(statusName);
            addStatus(subClass);
            String remark = new String();
            if (IsCellNull(sheetAt, i, CELL_NUM).getSuccess()) {
                remark = sheetAt.getRow(i).getCell(4).getStringCellValue();
            }
            if (code.length()>50||name.length()>50||remark.length()>200) {
                return ResultVoBuild.defeated(ERROR_IMPORT_FIELD_OUTSIZE);
            }
            subClass.setRemark(remark);
            subClasses.add(subClass);
            subClassList.add(subClass);
        }
        Boolean result= subClassRepeat(subClassList);
        if(result){
            return ResultVoBuild.defeated(ERROR_IMPORT_REPEAT);
        }
        subClassMapper.insertByImport(subClasses);
        return ResultVoBuild.success(subClassList);
    }





}
