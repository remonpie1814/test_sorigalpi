package com.spring.sorigalpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sorigalpi.base.Base;
import com.spring.sorigalpi.dto.MemberDto;
import com.spring.sorigalpi.entity.Member;
import com.spring.sorigalpi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService extends Base {

   @Autowired
	private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    
    @Transactional
    public String createMember(MemberDto memberDto) { // 사용자 추가 메소드
    	memberDto.setMemberId(createRandomUuId());;
    	return memberRepository.save(memberDto.toEntity()).getNickName() + "님 환영합니다.";
    }
    
    public List<Member> listMembers(){ // 사용자 조회 메소드
    	return memberRepository.findAll();
    }
    @Transactional
    public String updateMember(String memberId, MemberDto memberDto) { // 사용자 정보 변경 메소드
    	//findById 메소드를 통해 값을 가져오면서 해당 값은 영속성을 가진다.
    	Member member = memberRepository.findById(memberId).orElseThrow(
    			() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
    	//값 변경
    	member.updateMember(memberDto.getEmail(), memberDto.getPwd(), memberDto.getNickName(),
    			memberDto.getProfileImg(), memberDto.getStatus(),memberDto.getIntro(), memberDto.getRole());
    	return memberDto.getNickName() + "님 정보가 변경되었습니다.";
    	//트랜잭션이 끝나면서 변경된 값을 테이블에 적용
    	//update기능에서 JPA영속성 때문에 DB에 쿼리를 없애는 부분이 없으며, Entity의 값만 변경하면 별도로 update쿼리가 필요없다.
    }
    
    @Transactional
    public String deleteMember (String memberId) { // 사용자 삭제 메소드
    	memberRepository.findById(memberId).orElseThrow(() -> {
    		return new IllegalArgumentException("해당 사용자가 존재하지 않습니다.");
    	});
    	
    	memberRepository.deleteById(memberId);
    	return "탈퇴가 완료되었습니다.";
    }
    
    
    public String login(MemberDto memberDto) { // 로그인 메소드
        String email = memberDto.getEmail();
        String rawPassword = memberDto.getPwd();

        Member byEmail = memberRepository.findByEmail(email);

        // 비밀번호 일치 여부 확인
        if(passwordEncoder.matches(rawPassword, byEmail.getPwd())){
            return "로그인 성공";
        }

        return "로그인 실패";
    }
    	} 

