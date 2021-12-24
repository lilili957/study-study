package com.lilili.controller;

import com.lilili.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author LiYuan
 * @Date 2021/11/3
 **/
@Slf4j
@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @GetMapping("/get")
    public String get(String name) {
        log.info("[get] - Parameter: name {}", name);
        return "你的名字是:" + name;
    }

    @GetMapping("/getEntity")
    public Student getEntity(String name, Integer gender, String nickName) {
        log.info("[getEntity] - Parameter: name {}, gender {}, nickName {}", name, gender, nickName);
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setNickName(nickName);
        return student;
    }

    @PostMapping("/postEntity")
    public Student postEntity(@RequestBody Student student) {
        log.info("[postEntity] - Parameter: student {}", student);
        student.setId(1L);
        return student;
    }

    @PostMapping("/updateEntity")
    public Student updateEntity(String name, Integer gender, String nickName) {
        log.info("[updateEntity] - Parameter: name {}, gender {}, nickName {}", name, gender, nickName);
        Student student = new Student();
        student.setName(name + "957");
        student.setGender(gender);
        student.setNickName(nickName + "957");
        return student;
    }
}
