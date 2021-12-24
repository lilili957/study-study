package com.lilili.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilili.dao.StudentMapper;
import com.lilili.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/25
 **/
@Service("studentServiceImpl")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    @Override
    public void insertStudentList(List<Student> students) {
        for (Student student : students) {
            studentMapper.insert(student);
        }
    }
}
