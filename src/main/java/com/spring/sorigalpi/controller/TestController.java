package com.spring.sorigalpi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "test")
 @RestController
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "Hello World!";
	}
} 
