package com.lilili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@MapperScan(basePackages = "com.lilili.dao")
@SpringBootApplication
public class EasyexcelStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyexcelStudyApplication.class, args);
    }
}
