package com.ykc.service.common;

import com.ykc.component.exception.ServiceException;
import com.ykc.dao.common.SuperMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @ClassName AbstractBaseService
 * @Description 基于通用MyBatis Mapper插件的Service接口的实现
 * @Author hgq
 * @Date 2020/3/18 16:58
 * @Version 1.0
 */
public abstract class AbstractBaseService<T> implements BaseService<T> {

    /*@Autowired
    private SuperMapper<T> mapper;*/

    protected abstract SuperMapper<T> getMapper();

    /**
     * 当前泛型真实类型的Class
     */
    private Class<T> modelClass;

    public AbstractBaseService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }


    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param model
     */
    @Override
    public int save(T model) {
        return getMapper().insertSelective(model);
    }



    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     *
     * @param models
     */
    @Override
    public int save(List<T> models) {
        return getMapper().insertList(models);
    }

    /**
     * 批量保存不是自增长ID
     * @param model
     */
    public int saveUid(T model){
        return getMapper().insertUid(model);
    }

    /**
     * 批量保存不是自增长ID
     * @param models
     */
    public int saveUidList(List<T> models){
        return getMapper().insertUidList(models);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param id
     */
    @Override
    public int deleteById(Integer id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     */
    @Override
    public int deleteByIds(String ids) {
        return getMapper().deleteByIds(ids);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param model
     */
    @Override
    public int update(T model) {
        return getMapper().updateByPrimaryKeySelective(model);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param id
     * @return
     */
    @Override
    public T findById(Integer id) {
        return getMapper().selectByPrimaryKey(id);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getField(fieldName);
            field.setAccessible(true);
            field.set(model, field);
            return getMapper().selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 例如："1,2,3"
     * @return
     */
    @Override
    public List<T> findByIds(String ids) {
        return getMapper().selectByIds(ids);
    }

    /**
     * 根据Condition条件进行查询
     *
     * @param condition
     * @return
     */
    @Override
    public List<T> findByCondition(Condition condition) {
        return getMapper().selectByCondition(condition);
    }

    /**
     * 查询全部结果
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }
}
