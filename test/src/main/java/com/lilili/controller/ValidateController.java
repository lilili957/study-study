package com.lilili.controller;

import com.lilili.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author LiYuan
 * @Date 2021/11/2
 **/
@RestController
@RequestMapping("/validate")
public class ValidateController {

    @Autowired
    Student student;

    @GetMapping("/student")
    public Student get() {
        return student;
    }
}
