package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectByNamePhoneTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		String name = "Goose";
		String phone = "01019191919";
		try {
			String obj = biz.getbynamephone(name, phone);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
