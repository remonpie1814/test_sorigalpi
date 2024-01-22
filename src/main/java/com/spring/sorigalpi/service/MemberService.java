package com.spring.sorigalpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sorigalpi.dto.SignUpDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

   @Autowired
	private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;


    /* 
    public String signUp(SignUpDto signupDto) {
		// ...
        return "회원가입";
        */
    
   /* public void signUp(Member member) throws TestException {
        Optional<Member> exist = memberRepository.findById(member.getMemberId());
        if(exist.isPresent()) {
            throw new TestException(HttpStatus.CONFLICT, "존재하는 ID 입니다.");
        }
        memberRepository.save(member);
    } */
    

    /* public String login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String pwd = loginDto.getPwd();

        Member byEmail =  memberRepository.findByEmail(email);

        // 비밀번호 일치 여부 확인
        if(passwordEncoder.matches(pwd, byEmail.getPwd())){
            return "로그인 성공";
        }

        return "로그인 실패"; */
    
    @Transactional
    public String save(SignUpDto signUpDto) { //사용자 추가 메소
    	return memberRepository.save(signUpDto.toEntity()).getMemberId();
    }
    
    public List<Member> findAll(){
    	return memberRepository.findAll();
    }
    	}

