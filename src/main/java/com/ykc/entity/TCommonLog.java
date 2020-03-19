package com.ykc.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * (TCommonLog)实体类
 *
 * @author makejava
 * @since 2020-03-19 10:03:11
 */
@Data
//需要驼峰转换为表名，不一致则需要指定表名
//@Table(name = "t_common_log")
public class TCommonLog {

    /**
    * 主键
    */
    @Id
    private Integer id;
    /**
    * 服务器IP
    */
    private String hostIp;
    /**
    * 日志类型（系统日志，，接口日志、业务日志、错误日志）
    */
    private String logType;
    /**
    * 日志描述
    */
    private String logDesc;
    /**
    * 模块ID
    */
    private String moudleId;
    /**
    * 模块描述
    */
    private String moudleDesc;
    /**
    * 功能ID
    */
    private String funId;
    /**
    * 功能描述
    */
    private String funDesc;
    /**
    * 请求方法
    */
    private String requestMethod;
    /**
    * 请求接口
    */
    private String requestUrl;
    /**
    * 请求参数
    */
    private String requestParam;
    /**
    * 日志内容
    */
    private String logContent;
    /**
    * 操作人
    */
    private String operatorName;
    /**
    * 操作ID
    */
    private String operatorId;
    /**
    * 创建时间
    */
    private Date createTime;

}