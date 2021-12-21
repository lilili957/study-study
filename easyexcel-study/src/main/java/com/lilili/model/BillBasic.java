package com.lilili.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liyuan
 * @since 2021-11-04
 */
@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
//@TableName(value = "bill_basic")
//@ExcelIgnoreUnannotated
public class BillBasic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String serialNumber;

    @ExcelProperty(value = "单位代码")
    private String agencyCode;

    @ExcelProperty(value = "交款人")
    private String payer;

    @ExcelProperty(value = "交款人类型")
    private Integer payerType;

    @ExcelProperty(value = "单位组织机构代码")
    private String creditCode;

    @ExcelProperty(value = "交款人手机号")
    private String payerTel;

    @ExcelProperty(value = "开票日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ExcelProperty(value = "开票人名字")
    private String author;

    @ExcelProperty("票据种类编码")
    private String billCode;

    @ExcelProperty("合计金额")
    private BigDecimal totalAmt;

    @ExcelProperty(value = "收款方式")
    private Integer recMode;

    @ExcelProperty(value = "备注")
    private String memo;
    private Integer status;
    private String billBatchCode;
    private String billNo;
    private String billCreateTime;
    private String random;
    private String batchNo;
    private Integer state;
    private String billName;
    private String errorMsg;
    private String isPrintPaper;
    private String paperBillBatchCode;
    private String paperBillNo;

    private Integer isScarlet;
    private String scarletBillBatchCode;
    private String scarletBillNo;
    private String scarletRandom;
    private String backBillBatchCode;
    private Integer billType;

    private String backScarletBillNo;
    private BigDecimal amt;
    private String writeoffReason;
    private String writeoffSerialNumber;
    private String newSerialNumber;
    private String newBillBatchCode;
    private String newBillNo;
    private String newRandom;
    private Integer createBy;
    private Integer auditBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime auditTime;
    private Integer auditStatus;
    private String auditReason;

    @ExcelProperty(value = "复核人")
    private String ext1Name;

    @ExcelProperty(value = "证件类型")
    private String ext1Value;

    @ExcelProperty(value = "证件号")
    private String ext2Name;
    private String ext2Value;
    private String ext3Name;
    private String ext3Value;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ExcelProperty("条目编码")
    private String itemCodee;
}
