package com.zdspring_boot2.student_login.annotion;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface annotionDemo{

    String value() default "";

}
