package com.zdspring_boot2.student_login.common.exception.handle;

import com.zdspring_boot2.student_login.common.exception.BaseException;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResponse handle(BaseException e) {
        return e.doException();
    }
}
