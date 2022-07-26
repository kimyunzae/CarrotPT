package com.first.TraineeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;

@SpringBootTest
class TraineeSelectByIdEmailTest {

	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		String id = "tid05";
		String email = "abc@naver.com";
		try {
			String obj = biz.findpwd(id, email);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
