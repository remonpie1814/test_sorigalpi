package com.spring.sorigalpi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sorigalpi.dto.LoginDto;
import com.spring.sorigalpi.dto.SignUpDto;
import com.spring.sorigalpi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;
    
    @PostMapping("/api/signUp")
    public String signUp(@RequestBody SignUpDto signUpDto) {

        return memberService.signUp(signUpDto);
    }
    
    @PostMapping("/api/login")
    public String login(@RequestBody LoginDto loginDto) {

        return memberService.login(loginDto);
    }
}

