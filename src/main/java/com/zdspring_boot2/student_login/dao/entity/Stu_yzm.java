package com.zdspring_boot2.student_login.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Stu_yzm {

    @Id
    @GeneratedValue
    private Integer id;

    private String stu_phone;

    private String yzm;

    private Integer yzm_status = 0;

    private Date create_time;


    @Override
    public String toString() {
        return "Stu_yzm{" +
                "id=" + id +
                ", stu_phone='" + stu_phone + '\'' +
                ", yzm=" + yzm +
                ", yzm_status=" + yzm_status +
                ", create_time=" + create_time +
                '}';
    }
}
