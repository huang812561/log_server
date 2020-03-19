package com.ykc.util;

import com.ykc.entity.common.LogConstants;
import com.ykc.entity.common.LogEnum;
import com.ykc.entity.common.ResponseEntity;
import com.ykc.entity.common.ResponsePageEntity;

/**
 * @ClassName ResponseUtils
 * @Description 返回对象工具类
 * @Author hgq
 * @Date 2020/3/19 13:14
 * @Version 1.0
 */
public class ResponseUtils {

    public static ResponseEntity success() {
        return new ResponseEntity()
                .setResultCode(LogEnum.SUCCESS.getCode())
                .setResultDesc(LogEnum.SUCCESS.getMessage());
    }

    public static ResponseEntity success(Object data) {
        return new ResponseEntity()
                .setResultCode(LogEnum.SUCCESS.getCode())
                .setResultDesc(LogEnum.SUCCESS.getMessage())
                .setData(data);
    }

    public static ResponsePageEntity successPage() {
        return (ResponsePageEntity) new ResponsePageEntity()
                .setPageIndex(LogConstants.NUMBER.ONE)
                .setPageSize(LogConstants.NUMBER.TEN)
                .setTotalCount(LogConstants.NUMBER.ZERO)
                .setTotalPage(LogConstants.NUMBER.ZERO)
                .setResultCode(LogEnum.SUCCESS.getCode())
                .setResultDesc(LogEnum.SUCCESS.getMessage());
    }

    public static ResponsePageEntity successPage(Object data, int totalPage, long totalCount) {
        return (ResponsePageEntity) new ResponsePageEntity()
                .setPageIndex(LogConstants.NUMBER.ONE)
                .setPageSize(LogConstants.NUMBER.TEN)
                .setTotalPage(totalPage)
                .setTotalCount(totalCount)
                .setResultCode(LogEnum.SUCCESS.getCode())
                .setResultDesc(LogEnum.SUCCESS.getMessage())
                .setData(data);
    }

    public static ResponsePageEntity successPage(Object data, int pageIndex, int pageSize, int totalPage, long totalCount) {
        return (ResponsePageEntity) new ResponsePageEntity()
                .setPageIndex(pageIndex)
                .setPageSize(pageSize)
                .setTotalPage(totalPage)
                .setTotalCount(totalCount)
                .setResultCode(LogEnum.SUCCESS.getCode())
                .setResultDesc(LogEnum.SUCCESS.getMessage())
                .setData(data);
    }

    public static ResponseEntity fail() {
        return new ResponseEntity()
                .setResultCode(LogEnum.INTERNAL_SERVER_ERROR.getCode())
                .setResultDesc(LogEnum.INTERNAL_SERVER_ERROR.getMessage());
    }

    public static ResponseEntity fail(int code, String message) {
        return new ResponseEntity()
                .setResultCode(LogEnum.INTERNAL_SERVER_ERROR.getCode())
                .setResultDesc(LogEnum.INTERNAL_SERVER_ERROR.getMessage())
                .setBussinessCode(code)
                .setBussinessDesc(message);
    }

    public static ResponseEntity fail(int bussinessCode, String bussinessMessage, Object data) {
        return new ResponseEntity()
                .setResultCode(LogEnum.INTERNAL_SERVER_ERROR.getCode())
                .setResultDesc(LogEnum.INTERNAL_SERVER_ERROR.getMessage())
                .setBussinessCode(bussinessCode)
                .setBussinessDesc(bussinessMessage)
                .setData(data);
    }

    public static ResponsePageEntity failPage() {
        return (ResponsePageEntity) new ResponsePageEntity()
                .setPageIndex(LogConstants.NUMBER.ONE)
                .setPageSize(LogConstants.NUMBER.TEN)
                .setTotalCount(LogConstants.NUMBER.ZERO)
                .setTotalPage(LogConstants.NUMBER.ZERO)
                .setResultCode(LogEnum.INTERNAL_SERVER_ERROR.getCode())
                .setResultDesc(LogEnum.INTERNAL_SERVER_ERROR.getMessage());
    }

    public static ResponsePageEntity failPage(int bussinessCode, String bussinessMessage, Object data) {
        return (ResponsePageEntity) new ResponsePageEntity()
                .setPageIndex(LogConstants.NUMBER.ONE)
                .setPageSize(LogConstants.NUMBER.TEN)
                .setTotalCount(LogConstants.NUMBER.ZERO)
                .setTotalPage(LogConstants.NUMBER.ZERO)
                .setResultCode(LogEnum.INTERNAL_SERVER_ERROR.getCode())
                .setResultDesc(LogEnum.INTERNAL_SERVER_ERROR.getMessage())
                .setBussinessCode(bussinessCode)
                .setBussinessDesc(bussinessMessage)
                .setData(data);
    }


}
