package com.lilili.model;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author liyuan
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName(value = "bill_items")
public class BillItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Long id;
    private Long billId;
    private String serialNumber;
    private String agencyCode;

    @ExcelProperty(value = "项目编号")
    private String itemCode;

    @ExcelProperty(value = "项目标准编号")
    private String itemStdCode;

    @ExcelProperty(value = "计量单位")
    private String unit;

    @ExcelProperty(value = "标准")
    private BigDecimal std;

    @ExcelProperty(value = "数量")
    private BigDecimal number;

    @ExcelProperty(value = "金额")
    private BigDecimal amt;

    private BigDecimal oldStd;
    private BigDecimal oldNumber;
    private BigDecimal oldAmt;

    private String itemExt1Name;

    private String itemExt1Value;

    private String itemExt2Name;

    private String itemExt2Value;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createTime;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updateTime;

    //TableField(exist=false)标识此字段不是数据库字段 MP注解
    @TableField(exist = false)
    @ExcelProperty("条目编号")
    private String itemCodee;
}
