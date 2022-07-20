package com.first.TraineeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;

@SpringBootTest
class TrainerSelectCntTest {

	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		try {
			int cnt = biz.getcnt();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
