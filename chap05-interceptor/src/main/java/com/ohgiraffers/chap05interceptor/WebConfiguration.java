package com.ohgiraffers.chap05interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // spring의 bean 설정 클래스
public class WebConfiguration implements WebMvcConfigurer {
                                        // spring mvc 설정 추가 용도
    @Autowired
    private StopWatchInterceptor stopWatchInterceptor;

    // 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopWatchInterceptor)
                // .stopwatch 경로에 등록한 인터셉터 적용
                .addPathPatterns("/stopwatch")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**");
    }
}
