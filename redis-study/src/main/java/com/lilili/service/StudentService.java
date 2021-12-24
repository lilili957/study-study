package com.lilili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lilili.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
public interface StudentService extends IService<Student> {

    @Transactional
    void insertStudentList(List<Student> student);

    Student getStudentById(Long id);
}
