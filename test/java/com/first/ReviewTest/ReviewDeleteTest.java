package com.first.ReviewTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewDeleteTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(1006);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
