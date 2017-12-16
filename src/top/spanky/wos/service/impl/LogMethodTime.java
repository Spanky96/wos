package top.spanky.wos.service.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import top.spanky.wos.AppContext;

public class LogMethodTime implements MethodInterceptor{

    private final Logger logger = Logger.getLogger(LogMethodTime.class);

    @Override
    public Object invoke(MethodInvocation invacation) throws Throwable {
        long startTime =  System.currentTimeMillis();

        Object returnValue = invacation.proceed();
        String methodName = invacation.getMethod().getName();
        long endTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append(AppContext.getAppContext().getUserId());
        sb.append(":");
        sb.append(invacation.getMethod().getDeclaringClass().getSimpleName());
        sb.append(":");
        sb.append(methodName);
        sb.append(":");
        sb.append(endTime - startTime);

        logger.info(sb.toString());
        return returnValue;
    }


}
