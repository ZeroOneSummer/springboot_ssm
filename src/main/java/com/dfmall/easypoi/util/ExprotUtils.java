package com.dfmall.easypoi.util;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.export.ExcelExportServer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.easypoi
 * Description: 导出工具类
 * Author: ZeroOneSummer
 * Date: 2018年04月22日 15:16
 */
public class ExprotUtils {

    public static Workbook exportExcel(List<Map<String, Object>> list, ExcelType type) {

        Workbook workbook;
        if (ExcelType.HSSF.equals(type)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        for (Map<String, Object> map : list) {
            ExcelExportServer server = new ExcelExportServer();
            ExportParams params = (ExportParams) map.get("params");
            Class<?> entity = (Class<?>) map.get("entity");
            Collection<?> data = (Collection<?>) map.get("data");
            server.createSheet(workbook, params, entity, data);
        }
        return workbook;
    }
}
