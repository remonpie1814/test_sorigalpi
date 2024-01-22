package com.spring.sorigalpi.dto;

import java.time.LocalDateTime;

import com.spring.sorigalpi.entity.Member;

import lombok.Getter;

@Getter
public class MemberListDto {
	private String memberId;
	private String email;
	private String pwd;
	private String nickName;
	private String profileImg;
	private LocalDateTime creDate;
	private String intro;
	private String status;
	private String role;
	
	public MemberListDto(Member Entity) {
		this.memberId = memberId;
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.profileImg = profileImg;
		this.creDate = creDate;
		this.intro = intro;
		this.status = status;
		this.role = role;
	}

}
