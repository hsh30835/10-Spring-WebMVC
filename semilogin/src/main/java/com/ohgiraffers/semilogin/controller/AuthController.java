package com.ohgiraffers.semilogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//로그인 요청을 받음

@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/fail") // 로그인 실패시
    public ModelAndView loginFail(@RequestParam String message, ModelAndView mv){
        mv.addObject("message",message);
        mv.setViewName("/auth/fail"); // /auth/fail로 보냄
        return mv;
    }
}
