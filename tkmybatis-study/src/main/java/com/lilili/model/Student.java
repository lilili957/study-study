package com.lilili.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@Data
public class Student implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private Integer gender;
    //Transient注解标识此字段不是数据库字段
    @Transient
    private String nickName;
}
