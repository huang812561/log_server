package com.ykc.service.common;

import com.ykc.dao.LogMapper;
import com.ykc.dao.common.SuperMapper;
import com.ykc.entity.TCommonLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogService
 * @Description 日志服务层
 * @Author hgq
 * @Date 2020/3/19 9:42
 * @Version 1.0
 */
@Service
public class LogService extends AbstractBaseService<TCommonLog> {
    @Autowired
    private LogMapper logMapper;

    @Override
    protected SuperMapper<TCommonLog> getMapper() {
        return this.logMapper;
    }
}
