package com.zdspring_boot2.student_login.config.Interceptor;


import com.zdspring_boot2.student_login.dao.YzmRepository;
import com.zdspring_boot2.student_login.common.exception.InterException;
import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Map;


@Component
public class YzmInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private YzmRepository yzmRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Content-Type", "text/html;charset=UTF-8");//解决乱码问题
        String yzm = request.getParameter("yzm");
        String phone = request.getParameter("phone");

        //判断验证码长度，状态，是否存在
        if(yzm.length() != 4 || yzmRepository.findYzmStatus(yzm).equals("1") || yzmRepository.findYzm(yzm).equals("")){
            throw new InterException(BaseResponseStatus.YZM_FAIL);
        }


        //判断验证码时效性
        Map<String,Object> timeMap = yzmRepository.findCreateTimeAndYzm(phone);
        Timestamp timestamp = (Timestamp) timeMap.get("create_time");

        if((System.currentTimeMillis() - timestamp.getTime()) > 10*1000){
            throw new InterException(BaseResponseStatus.EXCEPTION);
        }


        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}
}
