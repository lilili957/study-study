package com.lilili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@SpringBootApplication
@MapperScan(value = "com.lilili.dao")
public class TkmybatisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TkmybatisStudyApplication.class, args);
    }
}
