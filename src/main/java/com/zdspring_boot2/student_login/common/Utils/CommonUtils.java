package com.zdspring_boot2.student_login.common.Utils;

import com.zdspring_boot2.student_login.common.exception.LoginException;
import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;

import java.util.Random;

/**
 *  公共的工具类
 */
public class CommonUtils {


    /**
     * @param num 指定num位的验证码
     * 生成X位数的验证码
     */
    public static String getYzm(Integer num){

        // 判断 需要的位数验证码不为空  判断 需要的位数 不能为0
        if(num == null || num == 0){
            return null;
        }

        //字符串缓存  StringBuffer和 StringBuilder  前者线程安全后者线程不安全 后者速度快 便于处理大量的数据
        StringBuffer sb = new StringBuffer();
        // 追加 sb.append()

        //  x x x x
        for(int i = 0 ; i < num ; i++){
            sb.append(new Random().nextInt(9));
        }

        // 最后返回  sb.toString();

        return sb.toString();
    }

    /**
     *
     * @param phone
     * 检查手机号的合法性
     */
    public static boolean checkNum(String phone){
        String regex = "1[3,5,8]\\d{9}$";
        if(phone.matches(regex) && phone.length()==11){
            return true;
        }
        return false;
    }

    public static void checkNum1(String phone){
        String regex = "1[3,5,8]\\d{9}$";
        if(!phone.matches(regex) && phone.length()!=11){
            throw new LoginException(BaseResponseStatus.NOT_ALLOW_LOGIN,"手机号不合法！！！");
        }

    }



}
