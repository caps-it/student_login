package com.zdspring_boot2.student_login.dao;

import com.zdspring_boot2.student_login.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;


public interface StuRepository extends JpaRepository<Student, Integer> {

    //修改状态
    @Modifying
    @Query(value = "update `student` set `status` ='1' where phone=:phone", nativeQuery = true)
    Integer updatePhoneStatus(@Param("phone") String phone);

    //查询状态
    @Query(value = "select `status` from student where phone=:phone ", nativeQuery = true)
    String selectStatus(@Param("phone") String phone);

    //根据手机号核对表中的数据是否一致
    @Query(value = "select `identity`,`name`,`phone` from student where phone=:phone ", nativeQuery = true)
    Map<String, Object> selectMsg(@Param("phone") String phone);

    @Query(value = " select `identity` from student where identity=:identity ", nativeQuery = true)
    String checkIdetity(@Param("identity") String identity);

    @Query(value = " select `name` from student where name=:name ", nativeQuery = true)
    String checkName(@Param("name") String name);

    @Query(value = " select `phone` from student where phone=:phone", nativeQuery = true)
    String checkPhone(@Param("phone") String phone);
}