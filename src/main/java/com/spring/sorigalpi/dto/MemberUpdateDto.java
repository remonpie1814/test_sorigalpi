package com.spring.sorigalpi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
	public class MemberUpdateDto {

	private String email;
	private String pwd;
	private String nickName;
	private String profileImg;
	private String intro;
	
	@Builder
	public MemberUpdateDto (String email, String pwd, String nickName, String profileImg,
			String intro) {
		
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.profileImg = profileImg;
		this.intro = intro;
		
	
		
		}
	}

