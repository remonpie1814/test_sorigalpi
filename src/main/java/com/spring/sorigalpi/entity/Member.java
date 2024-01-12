package com.spring.sorigalpi.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table (name="t_member")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String memberId;
	
	private String email;
	private String pwd;
	private String nickName;
	
	private String profileImg;
	private String intro;
	
	private LocalDateTime creDate;
	
	private String role;
	private String status;
	
	/* @Enumerated(EnumType.STRING)
	private Role role;
	private Status status; */
		
	

public List<String> getRolesList(){
    if(this.role.length() > 0){
        return Arrays.asList(this.role.split(","));
    }
    return new ArrayList<>();
}
}

