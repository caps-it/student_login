package com.zdspring_boot2.student_login.common.exception;

import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import com.zdspring_boot2.student_login.common.responses.HttpResponses;

public class InterException extends BaseException {

    public InterException(BaseResponseStatus baseResponseStatus) {
        super(baseResponseStatus);
    }

    public InterException(BaseResponseStatus baseResponseStatus, String message) {
        super(baseResponseStatus, message);
    }

    @Override
    public BaseResponse doException() {
        return HttpResponses.baseResponse(BaseResponseStatus.YZM_FAIL.status);
    }
}
