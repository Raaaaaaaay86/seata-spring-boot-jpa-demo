package com.example.seatabusinessservice.config;

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
    SeataHandlerInterceptor seataHandlerInterceptor;

    @Autowired
    XidRequestInterceptor xidRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(new WebRequestHandlerInterceptorAdapter(xidRequestInterceptor)).addPathPatterns("/**");
    }
}
