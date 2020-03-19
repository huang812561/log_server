package com.ykc.dao.common;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @ClassName SuperMapper
 * @Description 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 * @Author hgq
 * @Date 2020/3/18 13:14
 * @Version 1.0
 */
public interface SuperMapper<T> extends BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T>,
        InsertUidMapper<T>,
        InsertUidListMapper<T> {
}
