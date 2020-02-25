package com.zdspring_boot2.student_login.common.responses;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FirstResponse extends BaseResponse {

    Object data;

    public FirstResponse(){}

    public FirstResponse(int status, String message,Object data) {
        super(status, message);
        this.data = data;
    }
}
