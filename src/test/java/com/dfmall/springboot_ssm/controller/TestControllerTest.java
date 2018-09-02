package com.dfmall.springboot_ssm.controller;

import com.dfmall.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.controller
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月02日 17:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
//@WebAppConfiguration
public class TestControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getSigletonList() {
        try {
            mvc.perform(MockMvcRequestBuilders.get("/test/sigle")
//                    .contentType(MediaType.APPLICATION_JSON_UTF8)
//                    .param("key","values")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}