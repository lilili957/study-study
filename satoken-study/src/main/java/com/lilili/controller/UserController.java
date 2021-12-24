package com.lilili.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiYuan
 * @Date 2021/11/18
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login(String username, String password) {
        if ("zhangsan".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登陆成功";
        }
        return "登录失败";
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录:" + StpUtil.isLogin();
    }
}
