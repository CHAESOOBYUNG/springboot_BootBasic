package com.simple.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.interceptor.UserAuthHandler;

@Configuration //스프링설정파일임을 의미
public class InterceptorConfig implements WebMvcConfigurer {

	//1. 유저 프리핸들러 bean으로 등록
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	//2. 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( userAuthHandler())
				//.addPathPatterns("/user/mypage")
				//.addPathPatterns("~~~~");
				.addPathPatterns("/user/*") //user로 시작하는 모든 경로에 적용
				.excludePathPatterns("/user/login"); //login페이지 제외
		
	}
	
	
	
}
