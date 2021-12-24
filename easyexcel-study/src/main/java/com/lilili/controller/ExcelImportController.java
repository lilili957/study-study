package com.lilili.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.lilili.model.BillBasic;
import com.lilili.model.BillItems;
import com.lilili.model.DemoData;
import com.lilili.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author LiYuan
 * @Date 2021/11/11
 **/
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelImportController {
    @Autowired
    DemoService demoService;

    @PostMapping("/import")
    public String excelImport(MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        log.info("读取文件开始");
//        File targetFile = new File("D:/Demo/excel/测试excel.xlsx");
//        if (targetFile.exists()) {
//            return "存在";
//        }
//
//        if (!targetFile.getParentFile().exists()) {
//            targetFile.getParentFile().mkdirs();
//        }
//        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
////        file.transferTo(targetFile);
//        file.transferTo(new File("D:/Demo/excel/testExcel.xlsx"));
        EasyExcel.read(file.getInputStream(), DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第一次");
            System.out.println(dataList);
        })).sheet().doRead();

        EasyExcel.read(file.getInputStream(), DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println("第二次");
            System.out.println(dataList);
        })).sheet().doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
        return "成功";
    }

    @PostMapping("/import2")
    public String excelImport2(MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        log.info("读取文件开始");
//        File targetFile = new File("D:/Demo/excel/测试excel.xlsx");
//        if (targetFile.exists()) {
//            return "存在";
//        }
//
//        if (!targetFile.getParentFile().exists()) {
//            targetFile.getParentFile().mkdirs();
//        }
//        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
////        file.transferTo(targetFile);
//        file.transferTo(new File("D:/Demo/excel/testExcel.xlsx"));
        EasyExcel.read(file.getInputStream(), BillBasic.class, new PageReadListener<BillBasic>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println(dataList);
        })).sheet().doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
        return "成功";
    }

    @PostMapping("/import3")
    public String excelImport3(MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        log.info("读取文件开始");
//        File targetFile = new File("D:/Demo/excel/测试excel.xlsx");
//        if (targetFile.exists()) {
//            return "存在";
//        }
//
//        if (!targetFile.getParentFile().exists()) {
//            targetFile.getParentFile().mkdirs();
//        }
//        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
////        file.transferTo(targetFile);
//        file.transferTo(new File("D:/Demo/excel/testExcel.xlsx"));
        EasyExcel.read(file.getInputStream(), BillItems.class, new PageReadListener<BillItems>(dataList -> {
//            demoService.saveBatch(dataList);
            System.out.println(dataList);
        })).sheet().doRead();
        long end = System.currentTimeMillis();
        log.info("总共耗时: {}s", ((end - start) / 1000));
        return "成功";
    }
}
