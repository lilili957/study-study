package com.lilili.controller;

import com.lilili.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LiYuan
 * @Date 2021/11/3
 **/
@Slf4j
@RestController
@RequestMapping("/rest")
public class RequestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public String get(String name) {
        String result = restTemplate.getForObject("http://localhost:8001/restTemplate/get?name={name}", String.class, name);
        return result;
    }

    @GetMapping("/getEntity")
    public Student getEntity(String name, Integer gender, String nickName) {
        ResponseEntity<Student> result = restTemplate.getForEntity("http://localhost:8001/restTemplate/getEntity?name={name}&gender={gender}&nickName={nickName}", Student.class, name, gender, nickName);
        return result.getBody();
    }

    @PostMapping("/postEntity")
    public Student postEntity(@RequestBody Student student) {
        log.info("[postEntity] - Parameter: student {}", student);
        ResponseEntity<Student> result = restTemplate.postForEntity("http://localhost:8001/restTemplate/postEntity", student, Student.class);
        return result.getBody();
    }

    @PutMapping("/updateEntity")
    public Student updateEntity(@RequestBody Student student) {
        log.info("[updateEntity] - Parameter: student {}", student);
        String name = student.getName();
        Integer gender = student.getGender();
        String nickName = student.getNickName();
        ResponseEntity<Student> resp = restTemplate.postForEntity("http://localhost:8001/restTemplate/updateEntity?name={name}&gender={gender}&nickName={nickName}", null, Student.class, name, gender, nickName);
        return resp.getBody();

    }
}
