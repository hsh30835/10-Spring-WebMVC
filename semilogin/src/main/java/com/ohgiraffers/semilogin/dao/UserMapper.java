package com.ohgiraffers.semilogin.dao;

import com.ohgiraffers.semilogin.dto.LoginUserDTO;
import com.ohgiraffers.semilogin.dto.SignupDTO;
import org.apache.ibatis.annotations.Mapper;

// 데이터베이스와 연동해줌

@Mapper
    public interface UserMapper {
        LoginUserDTO findByUserNickName(String userNickName); //닉네임에 해당하는 사용자 찾기

        int regist(SignupDTO signupDTO); //회원가입

//    LoginUserDTO findByUserEmail(String userEmail);

        int emailCheck(String userEmail); //이메일체크 아직 미구현
}