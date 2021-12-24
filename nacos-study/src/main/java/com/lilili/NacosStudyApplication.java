package com.lilili;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author LiYuan
 * @Date 2021/10/8
 **/
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class NacosStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosStudyApplication.class, args);
    }
}
