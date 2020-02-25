package com.zdspring_boot2.student_login.controller;


import com.zdspring_boot2.student_login.dao.StuRepository;
import com.zdspring_boot2.student_login.dao.YzmRepository;
import com.zdspring_boot2.student_login.dao.entity.LoginEntity;
import com.zdspring_boot2.student_login.annotion.annotionDemo;
import com.zdspring_boot2.student_login.common.Utils.CommonUtils;
import com.zdspring_boot2.student_login.dao.entity.Stu_yzm;
import com.zdspring_boot2.student_login.dao.entity.Student;
import com.zdspring_boot2.student_login.common.responses.BaseResponse;
import com.zdspring_boot2.student_login.common.neum.BaseResponseStatus;
import com.zdspring_boot2.student_login.common.responses.HttpResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class StuController {


    @Autowired
    private StuRepository stuRepository;

    @Autowired
    private YzmRepository yzmRepository;

    @RequestMapping("/in")
    public ModelAndView index(Model model){
        Student student = new Student();
        student.setName("张大帅");
        model.addAttribute("student",student);
        return new ModelAndView("index");
    }


    @GetMapping("/find")
    public BaseResponse list(){
        return HttpResponses.baseResponse(BaseResponseStatus.SUCCESS_SELECT.status,
                stuRepository.findAll());
    }


    @PostMapping("/create")
    public BaseResponse createStudent(@RequestParam("identity") String identity,
                                 @RequestParam("name") String name,
                                 @RequestParam("phone") String phone) {
        if(identity.equals(stuRepository.checkIdetity(identity))){
            return HttpResponses.baseResponse(BaseResponseStatus.FAIL_ID.status);
        }
        if(name.equals(stuRepository.checkName(name))){
            return HttpResponses.baseResponse(BaseResponseStatus.FAIL_NAME.status);
        }
        if(phone.equals(stuRepository.checkPhone(phone))){
            return HttpResponses.baseResponse(BaseResponseStatus.FAIL_PHONE.status);
        }
      Student student = new Student();
      student.setIdentity(identity);
      student.setName(name);
      student.setPhone(phone);
      stuRepository.save(student);

      return HttpResponses.baseResponse(BaseResponseStatus.SUCCESS_CREATE.status,student);

    }

    @GetMapping("/del/{id}")
    public BaseResponse delete(@PathVariable("id") Integer id){

       stuRepository.deleteById(id);

       return HttpResponses.baseResponse(BaseResponseStatus.FAIL_DEL.status);
    }

    //用户获取验证码
    @PostMapping("/getyzm")
    public BaseResponse getyzm(@RequestParam("phone") String phone){

        //获取验证码
        String Code = CommonUtils.getYzm(4);

        Stu_yzm stu_yzm = new Stu_yzm();
        stu_yzm.setStu_phone(phone);
        stu_yzm.setCreate_time(new Date());
        stu_yzm.setYzm(Code);
        yzmRepository.save(stu_yzm);

        return HttpResponses.baseResponse(BaseResponseStatus.SUCCESS.status,
                "验证码生成成功",Code);
    }

    @Transactional  //自定义数据库更新语句需要加事务处理注解
    @PostMapping("/login")
    @annotionDemo
    public BaseResponse Login(@RequestParam("identity") String identity,
                        @RequestParam("phone") String phone,
                        @RequestParam("yzm") String yzm) {
//
//        stuRepository.updatePhoneStatus(phone);
//        yzmRepository.updateYzmStatus(yzm);

        return HttpResponses.baseResponse(BaseResponseStatus.LOGIN_SUCCESS.status,
                new LoginEntity(identity,phone));

    }

    @PostMapping("/return/{phone}")
    public BaseResponse Test(@PathVariable("phone") String phone){
       String obtainPhone =  stuRepository.selectStatus(phone);

       if("1".equals(obtainPhone)){
           return HttpResponses.baseResponse(BaseResponseStatus.FAIL.status,1);
       }
       return HttpResponses.baseResponse(BaseResponseStatus.SUCCESS.status,0);
    }


}
