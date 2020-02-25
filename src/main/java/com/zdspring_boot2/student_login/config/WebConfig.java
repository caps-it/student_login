package com.zdspring_boot2.student_login.config;

import com.zdspring_boot2.student_login.config.Interceptor.YzmInterceptor;
import com.zdspring_boot2.student_login.config.Interceptor.PhoneInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    private final static Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    private YzmInterceptor yzmInterceptor;

    @Autowired
    private PhoneInterceptor phoneInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(phoneInterceptor).addPathPatterns("/login","/getyzm");
        registry.addInterceptor(yzmInterceptor).addPathPatterns("/login");
    }
}
