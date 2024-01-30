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

public class MemberDto { 

	private String memberId;
	private String email;
	private String pwd;
	private String nickName;
	private String profileImg;
	private String intro;
	private String status;
	private String role;
	
	@Builder
	public MemberDto(String memberId, String email, String pwd, String nickName, String profileImg,
			String intro,  String status,  String role) {
		
			this.memberId = memberId;
			this.email = email;
			this.pwd = pwd;
			this.nickName = nickName;
			this.profileImg = profileImg;
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
		.intro(intro)
		.status(status)
		.role(role)
		.build();
	}
}