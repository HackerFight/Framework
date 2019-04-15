package com.hacker.framework.interceptor;

import com.hacker.framework.util.LoggerUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:28
 *
 * @desc
 */
public class DalAccessInterceptor implements MethodInterceptor {

    private static final Logger RDS_DAL_LOGGER = LoggerFactory.getLogger("RDS_DAL");

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();

        //获取方法对象
        Method method = methodInvocation.getMethod();
        //获取完整的类名
        String className = method.getDeclaringClass().getName();
        //获取方法名
        String methodName = method.getName();
        //获取访问名
        String accessName = className + "." + methodName;
        RDS_DAL_LOGGER.info("开始调用接口方法:" + accessName);

        //是否用异常
        boolean accessSuc = true;

        //DAO
        try {
            Object proceed = methodInvocation.proceed();
            return proceed;
        } catch (Throwable throwable) {
            accessSuc = false;
            throw throwable;
        }finally {
            watch.stop();
            System.out.println(watch.getTotalTimeMillis());
            LoggerUtil.monitor(RDS_DAL_LOGGER, className, methodName, accessSuc, watch.getTotalTimeMillis());
        }
    }
}
