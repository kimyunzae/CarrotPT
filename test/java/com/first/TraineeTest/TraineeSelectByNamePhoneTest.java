package com.first.TraineeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;

@SpringBootTest
class TraineeSelectByNamePhoneTest {

	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		String name = "진만리";
		String phone = "0101212121";
		try {
			String obj = biz.getbynamephone(name, phone);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
