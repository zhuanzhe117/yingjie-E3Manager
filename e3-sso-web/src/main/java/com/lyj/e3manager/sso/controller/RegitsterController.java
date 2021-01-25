package com.lyj.e3manager.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册功能
 */
@Controller
public class RegitsterController {
    @RequestMapping("/page/register")
    public String RegitsterController(){
        return "register";
    }
}
