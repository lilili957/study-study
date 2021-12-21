package com.lilili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author LiYuan
 * @Date 2021/9/30
 **/
//启用缓存
@EnableCaching
@SpringBootApplication
public class RedisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisStudyApplication.class, args);
    }
}
