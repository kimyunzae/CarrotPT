package com.first.ReviewTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewSelectCntTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		try {
			cnt = biz.getcnt("tid01");
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
