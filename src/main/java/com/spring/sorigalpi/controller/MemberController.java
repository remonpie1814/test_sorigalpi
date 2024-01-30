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
import com.spring.sorigalpi.enumtype.MemberEnum.Role;
import com.spring.sorigalpi.enumtype.MemberEnum.Status;
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
	public String save(@RequestBody MemberDto memberDto) {
		
		return memberService.createMember(memberDto);
	}
	
	@GetMapping("/listMember")
	public List<Member> findAll(){
		return (List<Member>) memberService.listMembers();
	}
	
	@PutMapping("/updateMember/{memberId}")
		public String update(@PathVariable String memberId, @RequestBody MemberDto memberDto) {
			return memberService.updateMember(memberId, memberDto);
		}
	@DeleteMapping("/deleteMember/{memberId}")
	public void delete(@PathVariable String memberId) {
		memberService.deleteMember(memberId);
	}
}
	
	


