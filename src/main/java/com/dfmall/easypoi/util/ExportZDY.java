package com.dfmall.easypoi.util;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.easypoi.util
 * Description: 自定义导出的参数
 * Author: ZeroOneSummer
 * Date: 2018年04月22日 16:08
 */
@Data
public class ExportZDY {

    //实体集合
    private List<?> list;
    //反射实体
    private Class<?> clazz;
    //导出文件名
    private String fileName;
    //其他参数（如：标题，表名等）
    private ExportParams exportParams;
    //忽略导出的@excel(name)
    private String[] ignore;

    public ExportZDY(){}

    public ExportZDY(List<?> list, Class<?> clazz, String fileName, ExportParams exportParams, String[] ignore){
        this.list = list;
        this.clazz = clazz;
        this.fileName = fileName;
        this.exportParams = exportParams;
        this.ignore = ignore;
    }



    public static void excelExport(ExportZDY zdy, HttpServletResponse resp) throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put(NormalExcelConstants.CLASS, zdy.getClazz());
        map.put(NormalExcelConstants.FILE_NAME, zdy.getFileName());
        ExportParams ep = zdy.getExportParams();
        //不用导出的注解字段
        ep.setExclusions(zdy.getIgnore());
        map.put(NormalExcelConstants.PARAMS, ep);
        map.put(NormalExcelConstants.DATA_LIST, zdy.getList());

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list.add(map);
        //导出
        Workbook workbook = ExprotUtils.exportExcel(list, ExcelType.HSSF);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-download");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String filedisplay = date + zdy.getFileName() + ".xls";  //自定义导出文件名
        filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

        try {
            OutputStream out = resp.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
