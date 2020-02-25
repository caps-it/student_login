package com.zdspring_boot2.student_login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentLoginApplicationTests {

	@Test
	public void contextLoads() {
		Date date = new Date();
		System.out.println(date);

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

	}

}
