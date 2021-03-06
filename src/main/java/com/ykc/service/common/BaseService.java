package com.ykc.service.common;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description Service层 基础接口，其他Service 接口 请继承该接口
 * @Author hgq
 * @Date 2020/3/18 16:56
 * @Version 1.0
 */
public interface BaseService<T> {
    int save(T model);//持久化
    int save(List<T> models);//批量持久化
    int saveUid(T model);//持久化
    int saveUidList(List<T> models);//批量持久化
    int deleteById(Integer id);//通过主鍵刪除
    int deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    int update(T model);//更新
    T findById(Integer id);//通过ID查找
    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByCondition(Condition condition);//根据条件查找
    List<T> findAll();//获取所有
}
