package com.lilili.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
@Slf4j
@Aspect
@Component
public class MonitorAspect {

    @Around("@annotation(com.lilili.annotation.Monitor)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime before = LocalDateTime.now();
        log.debug("before: {}", before);
        Object result = joinPoint.proceed();
        LocalDateTime after = LocalDateTime.now();
        log.debug("after: {}", after);
        return result;
    }
}
