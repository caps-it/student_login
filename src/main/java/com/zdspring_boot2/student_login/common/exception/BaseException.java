package com.zdspring_boot2.student_login.common.exception;

import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * 异常基类
 *
 */

@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    private Integer code;
    private String message;


     public BaseException(BaseResponseStatus baseResponseStatus) {
        super(baseResponseStatus.getMsg());
        this.code = baseResponseStatus.getStatus();
    }

    public BaseException(BaseResponseStatus baseResponseStatus,String message){
        this.code = baseResponseStatus.getStatus();
        this.message = message;
    }

    /**
     * 基类处理错误返回的抽象方法
     */
    public abstract BaseResponse doException();

//    public static BaseException getBaseException(BaseResponseStatus baseResponseStatus) {
//        return new BaseException(baseResponseStatus) {
//            @Override
//            public BaseResponse doException() {
//                return null;
//            }
//        };
//    }

}
