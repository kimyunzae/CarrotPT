package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerUpdateProfile1Test {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		TrainerVO obj = new TrainerVO("tid05", "1.jpeg");
			
		try {
			biz.modifyProfile1(obj);
			System.out.println("update OK"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
