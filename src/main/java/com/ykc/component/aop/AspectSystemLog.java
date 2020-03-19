package com.ykc.component.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: AspectSystemLog
 * @Description: 系统日志切面
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 16:28
 */
@Aspect
@Component
@Order(1)
public class AspectSystemLog {


    @Pointcut("@annotation(com.ykc.component.annotation.SysLog)")
    public void logPointCut(){};

    @Around(value = "logPointCut()")
    public void arround(ProceedingJoinPoint joinPoint){
        try {
            long beginTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - beginTime;
            saveLog(joinPoint, time);
        } catch (Exception e) {
        } catch (Throwable throwable) {
        }
    }

    /**
     * 保存系统日志入库
     * @param joinPoint
     * @param time
     */
    public void saveLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //todo:保存日志入库
    }
}
