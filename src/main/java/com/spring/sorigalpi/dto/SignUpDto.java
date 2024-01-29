package com.spring.sorigalpi.dto;


import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.enumtype.MemberEnum.Role;
import com.spring.sorigalpi.enumtype.MemberEnum.Status;

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
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private Status status;
	
	@Builder
	public SignUpDto(String memberId, String email, String pwd, String nickName, String profileImg,
			LocalDateTime creDate,  String intro, Role role, Status status) {
		
			this.memberId = memberId;
			this.email = email;
			this.pwd = pwd;
			this.nickName = nickName;
			this.profileImg = profileImg;
			this.creDate = creDate;
			this.intro = intro;
			this.role = role;
			this.status = status;
		
}
	
   //toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
   public Member toEntity() {
	   Member member = Member.builder()
			   .memberId(memberId)
			   .email(email)
			   .pwd(pwd)
			   .nickName(nickName)
			   .profileImg(profileImg)
			   .creDate(creDate)
			   .role(role)
			   .status(status)
			   .build();
	   return member;
   }
}
