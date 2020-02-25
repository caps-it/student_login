package com.zdspring_boot2.student_login.common.neum;

/**
 * 返回状态类
 */

public enum  BaseResponseStatus {

    LOGIN_SUCCESS(20000,"登录成功"),
    LOGIN_FAIL(20004,"登录失败"),

    EXCEPTION(1234,"异常"),

    SUCCESS_SELECT(10000,"查询成功"),

    SUCCESS_CREATE(10001,"创建成功"),

    SUCCESS_DEL(100011,"删除成功"),
    FAIL_DEL(100012,"删除失败"),

    ALLOW_LOGIN(2001,"可以登录"),
    NOT_ALLOW_LOGIN(2002,"不允许重复登录"),

    YZM_FAIL(12001,"验证码错误或失效！！！"),

    SUCCESS(200,"成功可以登录"),
    FAIL(404,"失败不可登录"),

    FAIL_ID(40000,"身份数据不可用"),
    FAIL_NAME(40001,"用户名不可用"),
    FAIL_PHONE(40002,"手机号不可用");

    public int status;
    public String msg;

    BaseResponseStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    //同过状态码获取msg
    public static String getMsgByStatus(int status){
        BaseResponseStatus[] values = BaseResponseStatus.values();

        for(BaseResponseStatus type :values){
            if(type.status == status){
                return type.msg;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
