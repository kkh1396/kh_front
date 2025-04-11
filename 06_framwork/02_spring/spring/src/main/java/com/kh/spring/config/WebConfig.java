package com.kh.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터 등록 
		// * LoginInterceptor 
		registry.addInterceptor(new LoginInterceptor())
					 // .addPathPatterns("/member/mypage", "/board/enrollForm");
						.addPathPatterns("/member/mypage", "/notice/**"
											,"/board/**")    // 로그인을 안하면 접근을 막는 페이지 목록들
						.excludePathPatterns("/notice/list" , "/board/list");   // 위 막는 페이지들중 예외처리하여 접근 가능하도록 하는것
						
	}
	
	
}
