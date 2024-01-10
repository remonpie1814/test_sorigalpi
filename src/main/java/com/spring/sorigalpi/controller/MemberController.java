package com.spring.sorigalpi.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sorigalpi.dto.MemberFormDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final PasswordEncoder pwdEncoder;
	
	@GetMapping(value = "addMember")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
		
		return "member/memberForm";
	}
	
	@PostMapping(value = "/addMember")
	public String newMember(@Valid MemberFormDto memberFormDto) {
	Member member = Member.saveMember(memberFormDto, pwdEncoder);
	memberService.saveMember(member);
	
	return "redirect:/";
	}

}
