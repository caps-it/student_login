package com.zdspring_boot2.student_login.aspect;

import com.zdspring_boot2.student_login.dao.StuRepository;
import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import com.zdspring_boot2.student_login.common.responses.HttpResponses;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class AspectDemo {

    public static final Logger logger = LoggerFactory.getLogger(AspectDemo.class);

    @Autowired
    StuRepository stuRepository;

    /**
     * 切点
     */
    @Pointcut("@annotation(com.zdspring_boot2.student_login.annotion.annotionDemo)")
    public void pointCut(){}


    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    /**
     * 切面
     */
    @Around("pointCut()")
    public BaseResponse aspectDemo(ProceedingJoinPoint point) throws Throwable{
        logger.info("进入切面处理！");


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        String phone =  request.getParameter("phone");
        String obtainStatus = stuRepository.selectStatus(phone);


        logger.info("aspectDemo --- login() 前 ： " + phone);

//        // 调用 login()
//        Response response = (Response) point.proceed();
//        LoginEntity loginEntity = (LoginEntity) response.getData();
//        System.out.println(" aspectDemo --- login() 后 ： " + loginEntity.toString());
//        return response;

        // 调用 login()
        BaseResponse response = (BaseResponse) point.proceed();

        //判断手机号状态
        if("1".equals(obtainStatus)){
            return HttpResponses.baseResponse(BaseResponseStatus.NOT_ALLOW_LOGIN.status);
        }

        String message = response.getMsg();
        logger.info("aspectDemo --- login() 后 ： " + message );

        return response;

    }


}
