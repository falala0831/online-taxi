package com.bigbone.client.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().equals("/register.html") ||
                request.getRequestURI().equals("/name_repeated.html")){//是否进行登陆拦截
            return true;
        }
        Object passenger = request.getSession().getAttribute("passenger");
        Object driver = request.getSession().getAttribute("driver");
        if (passenger==null && driver==null){
            request.setAttribute("msg" ,"没有权限");
            response.sendRedirect("/login.html");
            return false;
        }else {
            return true;
        }
    }
}
