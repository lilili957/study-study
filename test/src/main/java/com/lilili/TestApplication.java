package com.lilili;

import com.lilili.model.Clzss;
import com.lilili.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author LiYuan
 * @Date 2021/11/2
 **/
@Import({Student.class, Clzss.class})
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Autowired
    Student student;
    @Autowired
    Clzss clzss;

    @Bean
    public ApplicationRunner applicationRunner() {
        return (args) -> {
            System.out.println(student);
            System.out.println(clzss);
        };
    }
}
