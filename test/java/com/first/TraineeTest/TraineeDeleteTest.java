package com.first.TraineeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;

@SpringBootTest
class TraineeDeleteTest {
	
	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove("id09");
			System.out.println("Delete OK");
		} catch (Exception e) {
			System.out.println("Delete FAIL");
			e.printStackTrace();
		}
	}

}
