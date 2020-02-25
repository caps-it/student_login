package com.zdspring_boot2.student_login.dao.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String phone;

    private String name;

    private String identity;

    private Integer status = 0;

    // war  jsp
    // tomcat1 线程数2000 队列 2000    16654  2mb 16 16  压力测试 100线程*1000请求  吞吐量 QPS
    // tomcat2 线程数2000 队列 2000    16654  2mb 16 16  压力测试 100线程*1000请求  吞吐量 QPS
    // 日活跃 1w    20w 用户

    // spring boot 内置 tomcat 200 100  jar  --- 服务器 jar

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", status=" + status +
                '}';
    }
}
