package com.spring.sorigalpi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.sorigalpi.dto.LoginDto;
import com.spring.sorigalpi.dto.SignUpDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;


    public String signUp(SignUpDto signupDto) {
		// ...
        return "회원가입";
    }

    public String login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String pwd = loginDto.getPwd();

        Member byEmail =  memberRepository.findByEmail(email);

        // 비밀번호 일치 여부 확인
        if(passwordEncoder.matches(pwd, byEmail.getPwd())){
            return "로그인 성공";
        }

        return "로그인 실패";
    }
}
