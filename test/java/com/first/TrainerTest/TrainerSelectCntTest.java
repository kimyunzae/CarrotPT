package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectCntTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		String status = "거절";
		try {
			int cnt = biz.getcnt(status);
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
