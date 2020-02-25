package com.zdspring_boot2.student_login.common.exception;


import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import com.zdspring_boot2.student_login.common.responses.HttpResponses;

public class LoginException extends BaseException {

    private String loginMsg;

    public LoginException(BaseResponseStatus baseResponseStatus) {
        super(baseResponseStatus);
    }

    public LoginException(BaseResponseStatus baseResponseStatus,String loginMsg){
        super(baseResponseStatus);
        this.loginMsg = loginMsg;
    }


    @Override
    public BaseResponse doException() {
        return HttpResponses.baseResponse(BaseResponseStatus.NOT_ALLOW_LOGIN.status,loginMsg);
    }
}
