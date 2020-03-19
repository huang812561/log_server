package com.ykc.dao;

import com.ykc.dao.common.SuperMapper;
import com.ykc.entity.TCommonLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName LogMapper
 * @Description TODO
 * @Author hgq
 * @Date 2020/3/19 15:47
 * @Version 1.0
 */
@Mapper
public interface LogMapper extends SuperMapper<TCommonLog> {
}
