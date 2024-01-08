package com.spring.sorigalpi.entity;

import java.sql.Date;

import javax.persistence.*;

import com.spring.sorigalpi.constant.Role;
import com.spring.sorigalpi.constant.Status;

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
   
	

}
