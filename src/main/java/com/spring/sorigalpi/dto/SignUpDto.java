package com.spring.sorigalpi.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.enumtype.MemberEnum.Role;
import com.spring.sorigalpi.enumtype.MemberEnum.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SignUpDto { //회원 가입 화면으로부터 넘어오는 가입정보를 담을 Dto

	private String memberId;
	private String email;
	private String pwd;
	private String nickName;
	private String profileImg;
	private LocalDateTime creDate;
	private String intro;
	private Status status;
	private Role role;
	
	@Builder
	public SignUpDto(String memberId, String email, String pwd, String nickName, String profileImg,
			LocalDateTime creDate,  String intro,  Status status,  Role role) {
		
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
	
	//Entity 클래스인 Member에 객체를 주입하여 Entity 클래스를 반환하는 메소드
	public Member toEntity() {
		return Member.builder()
			.memberId(memberId)
		.email(email)
		.pwd(pwd)
		.nickName(nickName)
		.profileImg(profileImg)
		.creDate(creDate)
		.intro(intro)
		.status(status)
		.role(role)
		.build();
	}
}