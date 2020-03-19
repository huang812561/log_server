package com.ykc.entity.common;

import lombok.Data;

/**
 * @ClassName BaseEntity
 * @Description 基础类
 * @Author hgq
 * @Date 2020/3/18 11:01
 * @Version 1.0
 */
@Data
public class BaseEntity extends AbstractBaseEntity {

    /**
     * 主键(建议使用雪花算法)
     */
    private String id;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 删除标识
     */
    private String delFlag;
}
