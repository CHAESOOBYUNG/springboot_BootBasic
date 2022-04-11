package com.simple.basic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.simple.basic.command.UserVO;

public class UserAuthHandler implements HandlerInterceptor{

	//회원페이지에 관련된 요청이 들어올 때 요청을 가로채 검사할 인터셉터
	//HandlerInterceptor 인터페이스를 상속받는다.
	//prehandle은 컨트롤러 요청이 들어가기 전에 가로챕니다.
	//스프링 설정파일에 인터셉터 핸들러를 bean으로 등록. 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//반환이 true면 컨트롤러를 실행함, 반환이 false라면 컨트롤러를 실행하지 않는다.
		System.out.println("유저 어스 인터셉터 실행됨");
		
		//세션에서 userVO를 얻는다.
		HttpSession session = request.getSession();
		
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		
		if(userVO == null) { //로그인이 안된시점
			
			response.sendRedirect( request.getContextPath() + "/user/login"); //로그인페이지 
			return false; //컨트롤러를 실행하지 않음
		} else { //로그인이 된 시점
			
			return true; //컨트롤러를 실행함
		}
		
	}
	
	
	
}
