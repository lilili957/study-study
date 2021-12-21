package com.lilili.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@Data
public class Student implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer gender;
    private String nickName;
}
