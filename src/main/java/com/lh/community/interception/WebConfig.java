package com.lh.community.interception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lanhu
 * @create 2020-01-23 18:03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterception sessionInterception;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterception).addPathPatterns("/**");
    }
}
