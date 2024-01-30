package com.spring.sorigalpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sorigalpi.dto.MemberDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.service.MemberService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
@Api(tags="member")
@RestController("memberController")
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

	@Autowired
    private final MemberService memberService;
  
	@PostMapping("/signUp")
	public String createMember(@RequestBody MemberDto memberDto) {
		
		return memberService.createMember(memberDto);
	}
	
	@GetMapping("/listMembers")
	public List<Member> listeMembers(){
		return (List<Member>) memberService.listMembers();
	}
	
	@PutMapping("/updateMember/{memberId}")
		public String updatMember(@PathVariable String memberId, @RequestBody MemberDto memberDto) {
			return memberService.updateMember(memberId, memberDto);
		}
	@DeleteMapping("/deleteMember/{memberId}")
	public String deleteMember(@PathVariable String memberId) {
		return memberService.deleteMember(memberId);
	}
}
	
	


