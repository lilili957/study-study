package com.lilili.config;

import com.lilili.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LiYuan
 * @Date 2021/11/2
 **/
@Configuration
public class InjectConfiguration {

    @Value("${student.name}")
    String name;

    @Value("${student.password}")
    String password;

//    @Bean
    public Student student() {
        System.out.println("student装配");
        return new Student(name, password);
    }
}
