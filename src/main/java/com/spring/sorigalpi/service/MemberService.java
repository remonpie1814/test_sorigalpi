package com.spring.sorigalpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sorigalpi.dto.LoginDto;
import com.spring.sorigalpi.dto.MemberUpdateDto;
import com.spring.sorigalpi.dto.SignUpDto;
import com.spring.sorigalpi.entity.BaseEntity;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService extends BaseEntity {

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
    public String save(SignUpDto signUpDto) { //사용자 추가 메소드
    	signUpDto.setMemberId(createRandomUuId());;
    	return memberRepository.save(signUpDto.toEntity()).getNickName() + "님 환영합니다.";
    }
    
    public List<Member> findAll(){
    	return memberRepository.findAll();
    }
    @Transactional
    public String update(String memberId, MemberUpdateDto memberUpdateDto) {
    	//findById 메소드를 통해 값을 가져오면서 해당 값은 영속성을 가진다.
    	Member member = memberRepository.findById(memberId).orElseThrow(
    			() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
    	//값 변경
    	member.update(memberUpdateDto.getEmail(), memberUpdateDto.getPwd(), memberUpdateDto.getNickName(),
    			memberUpdateDto.getProfileImg(), memberUpdateDto.getIntro(), member.getRole(),member.getStatus());
    	return memberId;
    	//트랜잭션이 끝나면서 변경된 값을 테이블에 적용
    	//update기능에서 JPA영속성 때문에 DB에 쿼리를 없애는 부분이 없으며, Entity의 값만 변경하면 별도로 update쿼리가 필요없다.
    }
    
    @Transactional
    public String delete (String memberId) {
    	Member member = memberRepository.findById(memberId).orElseThrow(() -> {
    		return new IllegalArgumentException("해당 사용자가 존재하지 않습니다.");
    	});
    	
    	memberRepository.deleteById(memberId);
    	return "삭제 완료";
    }
    
    public String login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String rawPassword = loginDto.getPwd();

        Member byEmail = memberRepository.findByEmail(email);

        // 비밀번호 일치 여부 확인
        if(passwordEncoder.matches(rawPassword, byEmail.getPwd())){
            return "로그인 성공";
        }

        return "로그인 실패";
    }
    	} 

