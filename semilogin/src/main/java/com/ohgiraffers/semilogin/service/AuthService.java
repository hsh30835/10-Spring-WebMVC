package com.ohgiraffers.semilogin.service;

import com.ohgiraffers.semilogin.model.AuthDetails;
import com.ohgiraffers.semilogin.dto.LoginUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

// 닉네임으로 찾은 유저를 로그인 시키는 기능

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserDTO login = memberService.findByUserNickName(username);
        if(Objects.isNull(login)){
            System.out.println("존재 안함");
            throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");
        }
        return new AuthDetails(login);
    }
}
