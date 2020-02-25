package com.zdspring_boot2.student_login.common.responses;


import lombok.Getter;
import lombok.Setter;

/**
 * 基础返回体
 */

@Setter
@Getter
public class BaseResponse {

    private int status;
    private String msg;

    public BaseResponse(){}

    public BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
