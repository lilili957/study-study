package com.lilili.controller;

import com.lilili.annotation.Monitor;
import com.lilili.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试使用Aop打印接口请求响应日志
 *
 * @Author LiYuan
 * @Date 2021/12/6
 **/
@RestController
@RequestMapping("/weblog")
public class WeblogController {

    @Monitor
    @PostMapping("/postTest")
    public Student postTest(@RequestBody Student student) {
        student.setName("李丽丽");
        return student;
    }
}
