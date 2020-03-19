package com.ykc.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ykc.entity.TCommonLog;
import com.ykc.entity.common.LogEnum;
import com.ykc.entity.common.RequestData;
import com.ykc.entity.common.ResponseEntity;
import com.ykc.entity.common.ResponsePageEntity;
import com.ykc.service.common.LogService;
import com.ykc.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author hgq
 * @Date 2020/3/19 10:11
 * @Version 1.0
 */
@RestController
@RequestMapping("log")
@Slf4j
public class LogController {

    @Autowired
    private LogService logService;


    /**
     * 查询所有日志
     *
     * @return
     */
    @RequestMapping("queryAll")
    public ResponseEntity queryAll() {
        List<TCommonLog> tCommonLogList = logService.findAll();
        return ResponseUtils.success(tCommonLogList);
    }

    /**
     * 查询分页日志
     *
     * @return
     */
    @RequestMapping("queryPageList")
    public ResponsePageEntity queryPageList() {
        Page<Object> page = PageHelper.startPage(1, 10);
        List<TCommonLog> tCommonLogList = logService.findAll();
        page.getTotal();
        return ResponseUtils.successPage(tCommonLogList, page.getPages(), page.getTotal());
    }

    /**
     * 根据ID查询日志信息
     *
     * @param id
     * @return
     */
    @RequestMapping("queryById")
    public ResponseEntity queryById(@RequestBody String id) {
        TCommonLog commonLog = logService.findById(Integer.valueOf(id));
        if (null == commonLog) {
            return ResponseUtils.fail(LogEnum.LOG_NOT_EXIST.getCode(), LogEnum.LOG_NOT_EXIST.getMessage());
        }
        return ResponseUtils.success(commonLog);
    }


    /**
     * 保存日志
     *
     * @param request
     * @return
     */

    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody RequestData<TCommonLog> requestData, HttpServletRequest request) {
        try {
            TCommonLog tCommonLog = requestData.getBody();
            tCommonLog.setHostIp(request.getRemoteAddr());
            tCommonLog.setCreateTime(new Date());
            int id = logService.save(tCommonLog);
            log.info("新增日志，内容:{},返回主键ID：{}", tCommonLog.toString(), id);
            return ResponseUtils.success(id);
        } catch (Exception e) {
            log.error("新增日志出现异常：{}", e);
            return ResponseUtils.fail();
        }
    }

    /**
     * 删除By ID
     *
     * @param id
     * @return
     */
    @RequestMapping("deletebyId")
    public ResponseEntity deletebyId(@RequestBody String id) {
        logService.deleteById(Integer.valueOf(id));
        return ResponseUtils.success();
    }
}
