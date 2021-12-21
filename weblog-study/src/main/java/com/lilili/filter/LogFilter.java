package com.lilili.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYuan
 * @Date 2021/12/6
 **/
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始");
        log.debug("url: {}", servletRequest.getRemoteAddr());
        log.debug("args: {}", getParameters((HttpServletRequest) servletRequest));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public Map<String, Object> getParameters(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = request.getParameter(key);
            map.put(key, value);
        }
        return map;
    }

    @Override
    public void destroy() {
    }
}
