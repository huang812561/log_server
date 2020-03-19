package com.ykc.entity.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName ResponseEntity
 * @Description 返回对象
 * @Author hgq
 * @Date 2020/3/19 10:12
 * @Version 1.0
 */
@ToString
public class ResponseEntity<T> implements Serializable {

    /**
     * 返回接口编码
     */
    private int resultCode = LogConstants.RETURN_CODE.SUCCESS;
    /**
     * 返回接口描述
     */
    private String resultDesc;
    /**
     * 返回接口编码
     */
    private int bussinessCode;
    /**
     * 返回业务描述
     */
    private String bussinessDesc;
    /**
     * 返回对象
     */
    private T data;

    public int getResultCode() {
        return resultCode;
    }

    public ResponseEntity setResultCode(int resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public ResponseEntity setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
        return this;
    }

    public int getBussinessCode() {
        return bussinessCode;
    }

    public ResponseEntity setBussinessCode(int bussinessCode) {
        this.bussinessCode = bussinessCode;
        return this;
    }

    public String getBussinessDesc() {
        return bussinessDesc;
    }

    public ResponseEntity setBussinessDesc(String bussinessDesc) {
        this.bussinessDesc = bussinessDesc;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity setData(T data) {
        this.data = data;
        return this;
    }
}
