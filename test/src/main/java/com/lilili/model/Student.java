package com.lilili.model;
;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/10/11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student  implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer gender;
    private String nickName;
    private String password;
    private Clzss clzss;


    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
