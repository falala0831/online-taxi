package com.bigbone.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //用户拦截器
    @Resource
    private LoginHandlerInterceptor LoginHandlerInterceptor;

    //解禁静态资源调取
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加要拦截的url
        registry.addInterceptor(LoginHandlerInterceptor).addPathPatterns("/**","/*.html")
                // 放行的路径
                .excludePathPatterns("/login.html","/client/account/**","/images/**","/js/**","/layui/**");
    }


}
