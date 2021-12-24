package com.lilili;

import com.lilili.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@SpringBootApplication
@MapperScan(value = "com.lilili.dao")
//启用事务管理
@EnableTransactionManagement
public class MybatisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisStudyApplication.class, args);
    }

    //一个类型有多个bean的时候通过name去匹配
    @Qualifier("studentServiceImpl")
    @Autowired
//    @Resource(name = "studentServiceImpl")
//    @Resource(type = StudentService.class)
//    @Resource(name = "studentServiceImpl", type = StudentService.class)
    StudentService studentService;

    @Bean
    public ApplicationRunner applicationRunner() {
        return (args) -> {
            System.out.println(studentService);
        };
    }
}
