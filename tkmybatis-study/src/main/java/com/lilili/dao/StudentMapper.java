package com.lilili.dao;


import com.lilili.model.Student;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.condition.UpdateByConditionMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/

public interface StudentMapper extends BaseMapper<Student>, InsertListMapper<Student> {

    int updateBatch(List<Student> list);
}
