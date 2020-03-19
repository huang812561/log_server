package com.ykc.entity.common;

import lombok.Data;

/**
 * @ClassName RequestData
 * @Description 请求实体
 * @Author hgq
 * @Date 2020/3/19 17:38
 * @Version 1.0
 */
@Data
public class RequestData<T> {

    /**
     * 请求头部信息
     */
    private Header header;
    /**
     * 请求参数
     */
    private T body;
}
