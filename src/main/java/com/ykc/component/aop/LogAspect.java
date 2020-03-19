package com.ykc.component.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ClassName LogAspct
 * @Description 请求接口日志
 * @Author hgq
 * @Date 2020/3/18 11:06
 * @Version 1.0
 */
@Aspect
@Order(-1)
@Slf4j
public class LogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 第一个【*】：表示返回值的类型任意；
     * 【com.ykc】：AOP所切的服务的包名，即，我们的业务部分
     * 【..】：表示当前包及子包
     * 第二个【*】：表示类名，*即所有类。此处可以自定义
     * 【.*(..)】：表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
    @Pointcut(value = "execution(* com.ykc..*.*(..))")
    public void executeService() {
    }

    /**
     * 请求参数打印
     *
     * @param joinPoint
     */
    @Before(value = "executeService()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        log.info("请求URL:{}", request.getRequestURL().toString());
        log.info("请求方式:{}", request.getMethod());
        log.info("请求IP:{}" + request.getRemoteAddr());
        log.info("请求方法:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数:{}", JSONObject.toJSONString(joinPoint.getArgs()));
    }

    /**
     * 返回接口耗时
     * @param object
     */
    @AfterReturning(returning = "object", value = "executeService())")
    public void doAfter(Object object) {
        log.info("--------------返回内容----------------");
        log.info("Response内容:{}",JSONObject.toJSONString(object));
        log.info("--------------返回内容----------------");
        log.info("接口耗时（毫秒） :{}",(System.currentTimeMillis()-startTime.get()));
        startTime.remove();
    }


}
