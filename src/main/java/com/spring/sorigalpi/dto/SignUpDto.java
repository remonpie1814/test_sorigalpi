package com.spring.sorigalpi.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto { //회원 가입 화면으로부터 넘어오는 가입정보를 담을 Dto

	private String email;
	private String pwd;
	private String nickName;
}
