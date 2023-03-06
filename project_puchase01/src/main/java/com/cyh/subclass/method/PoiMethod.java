package com.cyh.subclass.method;

import com.cyh.subclass.bean.SubClass;
import com.cyh.util.ResultVo;
import com.cyh.util.ResultVoBuild;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.cyh.util.ParamUtil.STATUS_NAME_FALSE;
import static com.cyh.util.ParamUtil.STATUS_NAME_TRUE;

/**
 * @className: PoiMethod
 * @description: TODO 类描述
 * @author: CYH
 * @date: 2023/03/01 23:34
 * @Company: Copyright© [日期] by [作者或个人]
 **/
public class PoiMethod {
    public  Boolean subClassRepeat(List<SubClass> subClassList){
        Set<SubClass> set = new TreeSet<>(new Comparator<SubClass>() {
            @Override
            public int compare(SubClass o1, SubClass o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        set.addAll(subClassList);
        if(subClassList.size()>set.size()){
            return true;
        }
        return false;
    }
    public ResultVo IsCellNull(XSSFSheet sheet, Integer i, Integer j){
        XSSFCell cell = sheet.getRow(i).getCell(j);
        i=i+2;
        j=+j;
        ResultVo resultVo = new ResultVo<>();
        if(cell==null){
            resultVo.setErrorMessage("第"+i+"行，第"+j+"列为空！！");
            return resultVo;
        }else {
            return ResultVoBuild.success();
        }
    }
    public SubClass addStatus(SubClass subClass){
        if(subClass.getStatusName().equals(STATUS_NAME_TRUE)){
            subClass.setStatus(true);
        }else if(subClass.getStatusName().equals(STATUS_NAME_FALSE)) {
            subClass.setStatus(false);
        }
        return subClass;
    }
}
