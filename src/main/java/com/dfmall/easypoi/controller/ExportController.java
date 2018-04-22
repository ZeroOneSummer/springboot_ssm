package com.dfmall.easypoi.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.dfmall.easypoi.entity.User;
import com.dfmall.easypoi.entity.User2;
import com.dfmall.easypoi.util.ExportZDY;
import com.dfmall.easypoi.util.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.easypoi.controller
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月22日 14:37
 */
@Slf4j
@RequestMapping("/export")
@Controller
public class ExportController {

    @RequestMapping("/user")
    public void excelAnno(HttpServletResponse resp) throws Exception {
        //模拟DB数据
        List<User> list = UserModel.getUsers();

        log.info("start exprot ......");

        //其他参数（null时无标题栏）
        ExportParams exportParams = new ExportParams("这是标题栏", "这是sheet表名");
        //忽略导出(null时不忽略)
        String[] ignore = new String[]{"年龄"};
        ExportZDY exportZDY = new ExportZDY(list, User.class, "顾客产品报表", exportParams, ignore);
        ExportZDY.excelExport(exportZDY, resp);

        log.info("end exprot ......");
    }


    @RequestMapping("/user2")
    public void excelAnno2(HttpServletResponse resp) throws Exception {
        //模拟DB数据
        List<User2> list = UserModel.getUser2s();

        log.info("start exprot ......");

        //其他参数（null时无标题栏）
        ExportParams exportParams = new ExportParams(null, "这是sheet表名");
        //忽略导出
        String[] ignore = new String[]{"年龄"};
        ExportZDY exportZDY = new ExportZDY(list, User2.class, "顾客产品报表", exportParams, ignore);
        ExportZDY.excelExport(exportZDY, resp);

        log.info("end exprot ......");
    }

}
