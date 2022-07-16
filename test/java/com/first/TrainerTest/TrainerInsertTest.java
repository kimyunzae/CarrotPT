package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerInsertTest {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		TrainerVO obj = new TrainerVO("tid34", "pwd34", "Cougar", "01034343434", "cgr@gmail.com", "m", "헬스", "요가마나옴", "60121", "서울특별시 성북구", "1층", "요가마나옴입니다", "요가 강사 5년", "license.jpg", null, null, "profile.jpg", null, null);
		try {
			biz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
