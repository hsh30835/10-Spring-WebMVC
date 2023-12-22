package com.ohgiraffers.semilogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// 로그인 성공시 각 사용자에 맞는 권한에 맞는 페이지로 이동

@Controller
public class IndexController {
    @GetMapping
    public String root(){
        return "index";
    }

    @GetMapping("/admin/page") // 관리자 페이지로 이동
    public ModelAndView admnin(ModelAndView mv){
        mv.setViewName("admin/admin");
        return mv;
    }

    @GetMapping("/user/page") // 사용자 페이지로 이동
    public ModelAndView user(ModelAndView mv){
        mv.setViewName("/user/user");
        return mv;
    }
}
