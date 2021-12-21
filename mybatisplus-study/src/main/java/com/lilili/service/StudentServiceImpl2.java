package com.lilili.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilili.dao.StudentMapper;
import com.lilili.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
@Service("studentServiceImpl2")
public class StudentServiceImpl2  extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public void insertStudentList(List<Student> student) {

    }
}
