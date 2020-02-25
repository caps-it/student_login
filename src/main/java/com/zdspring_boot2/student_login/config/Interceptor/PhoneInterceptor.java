package com.zdspring_boot2.student_login.config.Interceptor;

import com.zdspring_boot2.student_login.common.Utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class PhoneInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Content-Type", "text/html;charset=UTF-8");//解决乱码问题

        String phone =  request.getParameter("phone");

       if(!CommonUtils.checkNum(phone)){
           response.getWriter().print("手机号不合法,或手机号所在账户已经登录");
           return false;
       }
           return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}
}
