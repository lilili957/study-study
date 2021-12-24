package com.lilili;

import com.lilili.annoatation.EnableFruit;
import com.lilili.model.Fruit;
import com.lilili.model.Person;
import com.lilili.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
@SpringBootApplication
@EnableFruit
public class AutoconfigurationStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoconfigurationStudyApplication.class, args);
    }

    //spring.factories中开启了Student,Clzss的自动装配， 并没有开启Person的自动装配， 所以注入Person的时候会报错
    @Autowired
    Student student;
//    @Autowired
//    Person person;
    //这个是实现了ImportSelect接口，在方法中将我们需要自动转配的类返回， 然后就会注册到容器当中。
    //(EnableFruit包含Import注解)Import注解将实现类导入， 然后会注册到容器当中， 容器启动的时候后就会去调用这个实现类的方法， 将需要装配的类注册到容器中。
    @Autowired
    Fruit fruit;

    @Bean
    public ApplicationRunner applicationRunner() {
        return (args) -> {
            System.out.println(student);
//            System.out.println(person);
            System.out.println(fruit);
        };
    }

}
