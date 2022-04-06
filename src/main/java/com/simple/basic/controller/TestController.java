package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/home")
	public String test() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping("hello2")
	public String hello2() {
		
		return "안녕하세요2";
	}
	
	
}
