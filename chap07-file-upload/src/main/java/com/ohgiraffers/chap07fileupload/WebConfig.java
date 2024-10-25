package com.ohgiraffers.chap07fileupload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 정적 자원을 처리하기 위한 메소드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/single/**")
                .addResourceLocations("file:///C:/uploads/single/");
        registry.addResourceHandler("/img/multi/**")
                .addResourceLocations("file:///C:/uploads/multi/");
    }
}
