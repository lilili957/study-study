package com.lilili.controller;//package com.lilili.controller;

import com.lilili.model.Student;
import com.lilili.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 测试Transactional注解
     */
//    @GetMapping("/insertList")
//    public void insertList() {
//        ArrayList<Student> list = new ArrayList<>();
//        for (int i = 1; i < 20; i++) {
//            Student student = new Student();
//            student.setGender(i);
//            list.add(student);
//        }
//        Student student = new Student();
//        student.setGender(Integer.MAX_VALUE);
//        list.add(student);
//        studentService.insertStudentList(list);
//    }

    @GetMapping("/getById")
    public Student getById(Long id) {
        return studentService.getStudentById(id);
    }
}
