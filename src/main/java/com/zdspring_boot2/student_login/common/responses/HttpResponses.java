package com.zdspring_boot2.student_login.common.responses;

import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;

public final class HttpResponses {

    public static BaseResponse baseResponse(int status){
        return new BaseResponse(status,BaseResponseStatus.getMsgByStatus(status));
    }


    public static BaseResponse baseResponse(int status,Object object){
        return baseResponse(status,BaseResponseStatus.getMsgByStatus(status),object);
    }


    public static BaseResponse baseResponse(int status,String msg,Object data){

        FirstResponse response = new FirstResponse();
        response.setStatus(status);

        if(msg != null){
            response.setMsg(msg);
        }else{
            response.setMsg(BaseResponseStatus.getMsgByStatus(status));
        }
        response.setData(data);

        return response ;
    }



}
