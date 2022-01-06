package com.lilili.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;
import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2022/1/6
 **/
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    //发送目标
    private String target;
    //发送人
    private String from;
    //发送消息
    private String message;
}
