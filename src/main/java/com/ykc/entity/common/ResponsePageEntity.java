package com.ykc.entity.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName ResponsePageEntity
 * @Description 返回分页对象
 * @Author hgq
 * @Date 2020/3/19 10:12
 * @Version 1.0
 */
@ToString
public class ResponsePageEntity extends ResponseEntity implements Serializable {

    /**
     * 每页数量
     */
    private int pageSize = 10;
    /**
     * 分页索引值
     */
    private int pageIndex = 1;
    /**
     * 总页数
     */
    private int totalPage = 0;
    /**
     * 总条数
     */
    private long totalCount = 0;

    public int getPageSize() {
        return pageSize;
    }

    public ResponsePageEntity setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public ResponsePageEntity setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public ResponsePageEntity setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public ResponsePageEntity setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }
}
