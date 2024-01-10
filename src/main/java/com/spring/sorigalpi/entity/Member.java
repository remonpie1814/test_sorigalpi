package com.spring.sorigalpi.entity;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.sorigalpi.constant.Role;
import com.spring.sorigalpi.constant.Status;
import com.spring.sorigalpi.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_member")
@Getter
@Setter
@ToString
public class Member {
	
	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long memberId;
	private String name;
	
	@Column(unique = true)
	private String email;
	private String pwd;
	private String nickName;
	private String profileImg;
	private Date creDate;
	private String intro;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private Status status;
	
	public static Member saveMember(MemberFormDto memberFormDto, PasswordEncoder pwdEncoder) {
		Member member = new Member();
		member.setEmail(memberFormDto.getEmail());
		String pwd =pwdEncoder.encode(memberFormDto.getPwd());
		member.setNickName(memberFormDto.getNickName());
		member.setProfileImg(memberFormDto.getProfileImg());
		member.setCreDate(memberFormDto.getCreDate());
		member.setIntro(memberFormDto.getIntro());
		member.setRole(Role.user);
		member.setStatus(Status.active);
		
		return member;
	}

}
