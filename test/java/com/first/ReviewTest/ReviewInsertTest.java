package com.first.ReviewTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewInsertTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		ReviewVO obj = new ReviewVO("id05", "tid01", 5, null);
		try {
			biz.register(obj);
			System.out.println("Inserted" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
