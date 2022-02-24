package com.example.seataordersservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Deprecated // This Interceptor is currently not in used status.
@Configuration
@EnableWebMvc
public class InterceptorWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SeataHandlerInterceptor seataHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(seataHandlerInterceptor).addPathPatterns("/*/**");
    }
}
