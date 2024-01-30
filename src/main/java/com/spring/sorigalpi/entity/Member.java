package com.spring.sorigalpi.entity; 

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


import com.spring.sorigalpi.base.Base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table ( name = "t_member" )
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends Base {

    @Id
    @Column( name = "memberId" )
    private String memberId;

    @Column( name = "email" )
    private String email;
    @Column( name = "pwd" )
    private String pwd;
    @Column( name = "nickName" )
    private String nickName;


    @Column( name = "profileImg" )
    private String profileImg;
    @Column( name = "intro" )
    private String intro;


    @Column( name = "role" )
    private String role;
    @Column( name = "status" )
    private String status;


    public void member (String email, String pwd, String nickName, String profileImg,
            String intro, String status, String role) {

        this.email = email;
        this.pwd = pwd;
        this.nickName = nickName;
        this.profileImg = profileImg;
        this.intro = intro;
        this.status = status;
        this.role = role;
    }


}