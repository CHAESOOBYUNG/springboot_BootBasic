package com.simple.basic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UserVO;

@Controller
@RequestMapping("/user")
public class SessionController {
	
	//화면처리
	@GetMapping("/login")
	public void login() {
		
	}
	
	//화면처리
	@GetMapping("/success")
	public void success() {
		
	}
	
	//화면처리
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		
		//세션의 존재여부 확인..(로그인시 만들어지는 세션)
		//인가된 페이지가 50개라면??
//		if(session.getAttribute("userVO") == null) {
//			return "redirect:/user/login"; //다시 로그인 페이지로
//		}
		
		return "user/mypage";
	}
	
	//로그인폼
	@PostMapping("/login")
	public String loginForm(@Valid UserVO vo, Errors errors, 
							Model model, 
							HttpSession session) {
		
		//유효성검사
		if(errors.hasErrors()) {
			
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err: list) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			return "user/login"; //실패시 다시 로그인 페이지로 이동
		}
		
		//로그인.....
		//메서드모형 public UserVO login(UserVO vo);
		//SELECT * FROM 유저테이블 WHERE ID = ~~~ AND PW = ~~~;
		//UserVO의 값이 null이라면, 로그인 실패, null이 아니라면 로그인 성공
		
		//세션에 회원정보를 저장
		UserVO userVO = UserVO.builder().id("예제세션아이디").build();
		
		session.setAttribute("userVO", vo);
		
		
		
		return "redirect:/user/success"; //성공페이지로
	}
	
}
