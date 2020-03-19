package com.ykc.dao.common;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * @ClassName InsertUidMapper
 * @Description 通用Mapper接口,特殊方法，批量插入，主键是uid
 * @Author hgq
 * @Date 2020/3/18 18:49
 * @Version 1.0
 */
public interface InsertUidListMapper<T> {

        /**
         * 设置useGeneratedKeys为true，返回数据库自动生成的记录主键id
         *
         * @param recordList
         * @return
         */
        @Options(useGeneratedKeys = true, keyProperty = "uid")
        @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
        int insertUidList(List<T> recordList);
}
