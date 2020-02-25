package com.zdspring_boot2.student_login.dao.entity;


import lombok.Data;

@Data
public class LoginEntity {

    private String identity;
    private String phone;

    public LoginEntity(){

    }

    public LoginEntity(String identity, String phone ){
        this.identity = identity;
        this.phone = phone;

    }



}
