package com.dfmall.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试类
 */

@RestController
public class RabbitController {
    
    @Autowired
    private Sender sender;
    
    @RequestMapping("/mq")
    public void sendTest() throws Exception {
        for(int i = 0; i < 1; i++){
            String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String msg = "现在时间：" + dateStr;
            sender.send(msg);
            Thread.sleep(1000);
        }
    }
}
