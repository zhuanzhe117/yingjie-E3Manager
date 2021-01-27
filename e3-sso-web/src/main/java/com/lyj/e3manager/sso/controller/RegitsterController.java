package com.lyj.e3manager.sso.controller;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册功能
 */
@Controller
public class RegitsterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/page/register")
    public String RegitsterController(){

        return "register";
    }
    //判断用户、手机号是否注册过。做个验证
    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param, @PathVariable Integer type) {
        E3Result e3Result = registerService.checkData(param, type);
        return e3Result;
    }
}
