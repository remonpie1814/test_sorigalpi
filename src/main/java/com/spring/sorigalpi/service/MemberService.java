package com.spring.sorigalpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sorigalpi.dto.MemberFormDto;
import com.spring.sorigalpi.entity.Member;

@Transactional
public class MemberService {
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	public Member saveMember() { //join method
		MemberFormDto memberFormDto = new MemberFormDto();
		memberFormDto.setEmail("test@email.com");
		memberFormDto.setPwd("1234");
		memberFormDto.setNickName("닉네임");
		memberFormDto.setProfileImg(null);
		memberFormDto.setIntro(null);
		memberFormDto.setCreDate(memberFormDto.getCreDate());
		
		return Member.saveMember(memberFormDto,pwdEncoder);

	}
	
}
