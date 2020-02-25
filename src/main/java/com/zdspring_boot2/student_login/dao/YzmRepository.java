package com.zdspring_boot2.student_login.dao;

import com.zdspring_boot2.student_login.dao.entity.Stu_yzm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;


public interface YzmRepository extends JpaRepository<Stu_yzm,Integer> {

 // nativeQuery = true表示使用sql自己的方言查询，想查什么查什么， 按照字段数据类型返回就行了

    //查询验证码状态
    @Query(value = "select  `yzm_status` from `stu_yzm` where yzm = :yzm",nativeQuery = true)
    String findYzmStatus(@Param("yzm") String yzm);

    //更新验证码状态
    @Modifying
    @Query(value = "UPDATE `stu_yzm` SET `yzm_status`= 1 WHERE  yzm = :yzm",nativeQuery = true)
    Integer updateYzmStatus(@Param("yzm") String yzm);

    //根据手机查询验证码创建时间，状态
    @Query(value = "SELECT `create_time`, `yzm`, `yzm_status` FROM `stu_yzm` where stu_phone = :phone",nativeQuery = true)
    Map<String,Object> findCreateTimeAndYzm(@Param("phone") String phone);


    //查询验证码及其状态
    @Query(value = "SELECT `yzm` FROM `stu_yzm` where yzm = :yzm AND yzm_status = 0 ",nativeQuery = true)
    String findYzm(@Param("yzm") String yzm);


}
