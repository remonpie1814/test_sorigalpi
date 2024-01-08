package com.spring.sorigalpi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto { //회원 가입 화면으로부터 넘어오는 가입정보를 담을 Dto

	private String email;
	private String pwd;
	private String nickName;
}
