package com.first.ReviewTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewUpdateTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		ReviewVO obj = new ReviewVO(1000, 4, "수준을 잘 파악하고 도와주십니다.");
		try {
			biz.modify(obj);
			System.out.println("Updated" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
