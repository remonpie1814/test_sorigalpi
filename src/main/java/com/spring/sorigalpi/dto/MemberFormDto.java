package com.spring.sorigalpi.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto { //회원 가입 화면으로부터 넘어오는 가입정보를 담을 Dto

	//not null
	private String email;
	private String pwd;
	private String nickName;
	private Date creDate;
	
	//null 허용
	private String profileImg;
	private String intro;
}
