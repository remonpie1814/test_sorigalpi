package com.spring.sorigalpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sorigalpi.dto.LoginDto;
import com.spring.sorigalpi.dto.SignUpDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.service.MemberService;
import com.spring.sorigalpi.service.TestException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/sorigalpi")
@RequiredArgsConstructor
public class MemberController {

	@Autowired
    private final MemberService memberService;
    
	/*
    @PostMapping("/api/signUp")
    public String signUp(@RequestBody SignUpDto signUpDto) {

        return memberService.signUp(signUpDto);
    }
    
    @PostMapping("/api/login")
    public String login(@RequestBody LoginDto loginDto) {

        return memberService.login(loginDto);
    }
    
	@GetMapping("/test")
	public String test() {
		return "Hello World!";
	} */
	
	/* @RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public void signUp() throws TestException {
		
	    System.out.println("왜 안 오는데?"); */
		
	@PostMapping("/signUp")
	public String save(@RequestBody SignUpDto signUpDto) {
		return memberService.save(signUpDto);
	}
	
	}


