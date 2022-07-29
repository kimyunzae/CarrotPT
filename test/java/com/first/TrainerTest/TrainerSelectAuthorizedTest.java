package com.first.TrainerTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectAuthorizedTest {

	@Autowired
	TrainerBiz biz;
	

	@Test
	void contextLoads() {
		String loc = "군산";
		String major = null;
		
		try {
			List<TrainerVO> list = biz.getauthorized(loc, major);
			for (TrainerVO obj : list) {
				System.out.println(obj);
			}
			System.out.println(list.toArray().length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
