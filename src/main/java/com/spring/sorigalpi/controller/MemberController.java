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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
@Api(tags="member")
@RestController("memberController")
@RequestMapping(value = "/member")
@RequiredArgsConstructor

public class MemberController {

	@Autowired
    private final MemberService memberService;
  
	@ApiOperation(value="회원 가입", notes="회원 가입")
	@PostMapping("/signUp")
	public String createMember(@RequestBody MemberDto memberDto) {
		
		return memberService.createMember(memberDto);
	}
	
	@ApiOperation(value="로그인", notes="로그인")
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@ApiOperation(value="사용자 조회", notes="사용자 조회")
	@GetMapping("/listMembers")
	public List<Member> listeMembers(){
		return (List<Member>) memberService.listMembers();
	}
	
	@ApiOperation(value="사용자 정보 변경", notes="사용자 정보 변경")
	@PutMapping("/updateMember/{memberId}")
		public String updatMember( @ApiParam(name = "memberId", value = "사용자 고유 아이디", required = true) @PathVariable String memberId, @RequestBody MemberDto memberDto) {
			return memberService.updateMember(memberId, memberDto);
		}
	
	@ApiOperation(value="사용자 탈퇴", notes="사용자 탈퇴")
	@DeleteMapping("/deleteMember/{memberId}")
	public String deleteMember(
			@ApiParam(name = "memberId", value = "사용자 고유 아이디", required = true)
			@PathVariable String memberId) {
		return memberService.deleteMember(memberId);
	}
}
