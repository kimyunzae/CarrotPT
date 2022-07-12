package com.first.Trainer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;

@SpringBootTest
class TrainerDeleteTest {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove("tid10");
			System.out.print("Delete OK");
		} catch (Exception e) {
			System.out.print("Delete FAIL");
			e.printStackTrace();
		}
	}

}
