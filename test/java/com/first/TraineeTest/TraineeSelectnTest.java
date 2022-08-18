package com.first.TraineeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@SpringBootTest
class TraineeSelectnTest {
	
	@Autowired
	TraineeBiz biz;
	
	@Test
	void contextLoads() {
		String obj = null;
		try {
			obj = biz.selectn("id01");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


