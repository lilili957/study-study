package com.lilili.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@Data
@TableName(value = "excel_demo")
public class DemoData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ExcelProperty("第一列")
    private String string;
    @ExcelProperty("第二列")
    private String date;
    @ExcelProperty("第三列")
    private Double doubleData;
}
