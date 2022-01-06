package com.lilili.controller;

import com.lilili.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     *
     * params相当于一个conditions， 去定义请求的时候需要携带或不能携带什么样的参数
     * params = {"name", "!nickName"}，要求请求的时候必须携带key为name的参数，并且不能携带nickName的参数。
     * @param name
     * @return
     */
    @GetMapping(value = "/testParams", params = {"name", "!nickName"})
    public String testParams(String name, String nickName) {
        log.info("测试成功!");
        return "测试成功";
    }

    /**
     * 测试HttpURLConnection的Post请求
     */
    @PostMapping("/testURLConnection")
    public String testURLConnection(@RequestBody String request) {
        log.info("request:" + request);
        return "post请求返回结果";
    }

}
