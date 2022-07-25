package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerUpdateAccountTest {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		TrainerVO obj = new TrainerVO("tid02", "pwd02", "미가엘",
				"01023412222", "michael@gmail.com", "요가",
				"노바디짐","12345","ㄹㅁ","ㅁㄹ");
			
		try {
			biz.modifyAccount(obj);
			System.out.println("update OK"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
