package com.ykc.entity.common;

import lombok.Data;

/**
 * @ClassName RequestPageData
 * @Description 请求分页实体
 * @Author hgq
 * @Date 2020/3/19 17:38
 * @Version 1.0
 */
@Data
public class RequestPageData extends RequestData {
    /**
     * 分页索引值
     */
    private int pageIndex = 1;
    /**
     * 每页大小值
     */
    private int pageSize = 10;
}
