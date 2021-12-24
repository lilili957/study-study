package com.lilili.controller;

import com.alibaba.fastjson.JSONObject;
import com.lilili.model.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiYuan
 * @Date 2021/12/1
 **/
@RestController
@RequestMapping("/validator")
public class ValidatorController {

    @PostMapping
    public String post(@Validated @RequestBody Student student) {
        return JSONObject.toJSONString(student);
    }
}
