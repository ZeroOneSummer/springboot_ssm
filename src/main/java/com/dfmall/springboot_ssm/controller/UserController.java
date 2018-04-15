package com.dfmall.springboot_ssm.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSON;
import com.dfmall.springboot_ssm.common.Page;
import com.dfmall.springboot_ssm.common.Query;
import com.dfmall.springboot_ssm.common.R;
import com.dfmall.springboot_ssm.entity.User;
import com.dfmall.springboot_ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.controller
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 17:13
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public R getUsers(@RequestParam Map params){
        Query query = new Query(params);
        log.info("Input-/user/getUsers: " + JSON.toJSONString(query));

        List<User> list = userService.getAllUser(query);
        int total = userService.getCount(query);
        Page page = new Page(list, total ,query);

        log.info("Output-/user/getUsers: " + JSON.toJSONString(page));
        return R.ok(page);
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        log.info("Input-/user/getUserList: " + null);

        List<User> list = userService.getUsers();

        log.info("Output-/user/getUserList: " + list);
        return list;
    }

    @RequestMapping("/addUser")
    public R addUser(User user){
        log.info("Input-/user/addUser: " + JSON.toJSONString(user));

        int rtId = 0;
        try {
            userService.addUser(user);
            rtId = user.getId(); //返回插入后数据的
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Output-/user/addUser: " + rtId);
        return R.ok(rtId);
    }

    @RequestMapping("/excel")
    public void downloadExcel(HttpServletResponse response) throws Exception {
        log.info("Input-/user/excel: " + "开始导报表....");

        List<User> list = userService.getUsers();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),User.class, list);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String dataStr = (new SimpleDateFormat("yyyy.MM.dd")).format(new Date());
        response.setHeader("Content-Disposition", (new StringBuilder()).append("attachment;filename=").append(new String((new StringBuilder()).append(dataStr).append("测试报表").toString().getBytes("UTF-8"), "ISO8859-1")).append(".xls").toString());
        workbook.write(response.getOutputStream());

        log.info("Output-/user/excel: " + "报表导出完成!");
    }

}
