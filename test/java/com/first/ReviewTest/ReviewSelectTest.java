package com.first.ReviewTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewSelectTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		try {
			ReviewVO obj = biz.get(1001);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
