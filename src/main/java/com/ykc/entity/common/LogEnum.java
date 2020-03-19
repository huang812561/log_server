package com.ykc.entity.common;

/**
 * @ClassName LogEnum
 * @Description 返回响应编码和描述
 * @Author hgq
 * @Date 2020/3/19 11:35
 * @Version 1.0
 */
public enum LogEnum {
    /** result code   接口返回编码和描述 */
    SUCCESS(200,"成功"),
    FAIL(400,"失败"),
    UNAUTHORIZED(401,"未认证（签名错误）"),
    NOT_FOUND(404,"接口不存在"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),

    /** business code 业务类返回编码和描述    */
    LOG_SAVE_FAIL(10001,"日志报错异常"),
    LOG_NOT_EXIST(10002,"日志查询不存在"),




    ;

    LogEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
