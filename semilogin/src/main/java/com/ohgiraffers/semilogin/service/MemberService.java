package com.ohgiraffers.semilogin.service;

import com.ohgiraffers.semilogin.dao.UserMapper;
import com.ohgiraffers.semilogin.dto.LoginUserDTO;
import com.ohgiraffers.semilogin.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

// 로그인과 회원가입을 처리 하는 기능

@Service
public class MemberService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;

    public LoginUserDTO findByUserNickName(String userNickName){ // 닉네임으로 사용자를 찾음 찾은거로 AuthService에서 로그인함

        LoginUserDTO login = userMapper.findByUserNickName(userNickName);
        System.out.println(login);
        if(!Objects.isNull(login)){
            System.out.println("있");
            return login;
        }else{
            System.out.println("없");
            return null;
        }
    }

//    public LoginUserDTO findByUserEmail(String userEmail){
//
//        LoginUserDTO login = userMapper.findByUserEmail(userEmail);
//        System.out.println(login);
//        if(!Objects.isNull(login)){
//            System.out.println("있");
//            return login;
//        }else{
//            System.out.println("없");
//            return null;
//        }
//    }

    @Transactional
    public int regist(SignupDTO signupDTO){ // 회원가입
        signupDTO.setPassword(encoder.encode(signupDTO.getPassword()));
        int result = userMapper.regist(signupDTO);

        return result;
    }

//    public String emailCheck(String userEmail) {
//        String result = String.valueOf(userMapper.findByUserEmail(userEmail));
//        return result;
//    }

    public int emailCheck(String userEmail) { // 이메일 중복체크 아직 실패함
        System.out.println("서비스 체크");
        int result = userMapper.emailCheck(userEmail);
        return result;
    }
}
