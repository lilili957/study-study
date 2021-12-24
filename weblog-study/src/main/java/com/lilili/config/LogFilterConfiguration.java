package com.lilili.config;

import com.lilili.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LiYuan
 * @Date 2021/12/6
 **/
@Configuration
public class LogFilterConfiguration {

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new LogFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setName("logFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}
