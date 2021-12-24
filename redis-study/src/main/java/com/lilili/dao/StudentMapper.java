package com.lilili.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lilili.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student>  testRowBounds(RowBounds rowBounds);
}
