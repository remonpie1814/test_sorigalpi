package com.spring.sorigalpi.base;

import java.util.UUID;

public class Base { //중복되는 메소드들
	
	public String createRandomUuId() {	//UUID 생성
		
		String resultUuid = UUID.randomUUID().toString();
		
		return resultUuid;
	}
	
}
