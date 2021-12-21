package com.lilili.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYuan
 * @Date 2021/12/6
 **/
@Slf4j
@Aspect
//@Component
public class WeblogAspect {

    //定义切入点
    @Pointcut("execution(public * com.lilili.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("--------------------request-start--------------------");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.debug("REQUEST - HEADER: {}", JSONObject.toJSONString(getHeaderInfo(request)));
        log.debug("URL: {}", request.getRequestURL());
        log.debug("HTTP - METHOD: {}", request.getMethod());
        log.debug("REQUEST - ARGS: {}", JSONObject.toJSONString(joinPoint.getArgs()));
        log.debug("IP: {}", request.getRemoteAddr());
        log.debug("CLASS - METHOD:{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("----------环绕通知前----------");
        Object result = joinPoint.proceed();
        String s = result.toString();
        log.debug("RESPONSE - BODY: {}", JSONObject.toJSONString(s));
        return result;
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        log.debug("--------------------request-end--------------------");
    }

    public Map<String, Object> getHeaderInfo(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        HashMap<String, Object> map = new HashMap<String, Object>();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            map.put(header, value);
        }
        return map;
    }
}
