package com.ohgiraffers.semilogin.controller;

import com.ohgiraffers.semilogin.dto.SignupDTO;
import com.ohgiraffers.semilogin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// 회원가입 요청을 받음

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MemberService memberService;

    //회원가입
    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv){

        int result = memberService.regist(signupDTO);

        String message;
        if(result>0){
            message = "회원가입 완료";
            mv.setViewName("auth/clearSignup");
        }else {
            message = "회원가입 실패";
            mv.setViewName("auth/login");
        }
        System.out.println(result);
        mv.addObject("message",message);

        return mv;
    }

    // 이메일 중복체크
    @ResponseBody
    @PostMapping("/emailCheck")
    public int emailCheck(@RequestParam("userEmail") String userEmail){
        System.out.println("컨트롤러 체크");

        int result = memberService.emailCheck(userEmail);
        return result;
    }
//    @PostMapping("/emailCheck")
//    public @ResponseBody String emailCheck(@RequestParam String userEmail){
//        String checkResult = memberService.emailCheck(userEmail);
//        return checkResult;
//    }

}
