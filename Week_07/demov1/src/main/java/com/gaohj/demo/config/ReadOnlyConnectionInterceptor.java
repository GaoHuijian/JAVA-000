package com.gaohj.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyConnectionInterceptor  implements Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")//在注解上加入切入点语法，实现方法
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try{
            LOGGER.info("---------------set database connection  read only---------------");
            int randInt = (int)(Math.random()*100) % 2;
            if(randInt == 1){
                DataBaseContextHoldle.setDataBaseType(DataBaseContextHoldle.DataBaseType.READ1);
            }else{
                DataBaseContextHoldle.setDataBaseType(DataBaseContextHoldle.DataBaseType.READ2);
            }
            LOGGER.info("---------------set database connection  {} read only---------------", randInt);
            Object result = proceedingJoinPoint.proceed();
            //让这个方法执行完毕
            return result;
        } finally {
            DataBaseContextHoldle.cleanDataType();
            LOGGER.info("---------------clear database connection---------------");
        }
    }
}
