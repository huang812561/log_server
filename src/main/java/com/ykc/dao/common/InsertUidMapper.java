package com.ykc.dao.common;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

import java.util.List;

/**
 * @ClassName InsertUidMapper
 * @Description 通用Mapper接口, 特殊方法，单条插入，主键是uid
 * @Author hgq
 * @Date 2020/3/18 18:49
 * @Version 1.0
 */
public interface InsertUidMapper<T> {


    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    int insertUid(T record);
}
