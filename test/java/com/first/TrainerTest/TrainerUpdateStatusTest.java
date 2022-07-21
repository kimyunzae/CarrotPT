package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerUpdateStatusTest {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		TrainerVO obj = new TrainerVO("tid37", "거절", "내맘이야!");
		try {
			biz.modifystatus(obj);
			System.out.println("Updated" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
