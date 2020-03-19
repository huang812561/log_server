package com.ykc.controller;

import com.alibaba.fastjson.JSONObject;
import com.ykc.entity.TCommonLog;
import com.ykc.entity.common.Header;
import com.ykc.entity.common.LogEnum;
import com.ykc.entity.common.RequestData;
import com.ykc.entity.common.ResponseEntity;
import javafx.scene.transform.Shear;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sun.rmi.runtime.Log;

import java.nio.charset.Charset;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class LogControllerTest {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private RequestData requestData = new RequestData();

    @Before
    public void setUp() throws Exception {
        startTime.set(System.currentTimeMillis());
        log.info("单元测试执行开始............");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Header header = new Header();
        header.setBusinessID("111");
        header.setToken("token");
        requestData.setHeader(header);
    }

    @After
    public void tearDown() throws Exception {
        log.info("单元测试执行结束，用时：{} 毫秒.............", (System.currentTimeMillis() - startTime.get()));
        startTime.remove();
    }

    @Test
    public void queryAll() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/log/queryAll")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse().getContentAsString(Charset.defaultCharset());
        ResponseEntity responseEntity = JSONObject.parseObject(result, ResponseEntity.class);
        log.info("执行结果：{}", responseEntity.toString());
        Assert.assertEquals(responseEntity.getResultCode(), LogEnum.SUCCESS.getCode());
    }

    @Test
    public void queryPageList() {
    }

    @Test
    public void queryById() {
    }

    @Test
    public void save() throws Exception {
        TCommonLog tCommonLog = new TCommonLog();
        tCommonLog.setLogType("save");
        tCommonLog.setLogDesc("保存日志");
        tCommonLog.setCreateTime(new Date());
        requestData.setBody(tCommonLog);
        String resultStr = mockMvc.perform(MockMvcRequestBuilders.post("/log/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(requestData)))
                .andReturn().getResponse().getContentAsString(Charset.defaultCharset());
        ResponseEntity responseEntity = JSONObject.parseObject(resultStr, ResponseEntity.class);
        log.info("执行结果：", responseEntity.toString());
        Assert.assertEquals(responseEntity.getResultCode(), LogEnum.SUCCESS.getCode());
    }

    @Test
    public void deletebyId() throws Exception {
        String id = "1";
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/log/deletebyId")
                .accept(MediaType.APPLICATION_JSON).content(id))
                .andDo(MockMvcResultHandlers.print());
        log.info("删除日志By id ", id);
        Assert.assertEquals(result.andReturn().getResponse().getStatus(), LogEnum.SUCCESS.getCode());
    }
}