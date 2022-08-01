package com.first.ReviewTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReviewBiz;
import com.first.vo.ReviewVO;

@SpringBootTest
class ReviewSelectAllByTidTest {

	@Autowired
	ReviewBiz biz;
	
	@Test
	void contextLoads() {
		try {
			List<ReviewVO> list = biz.getbytid("tid05");
			for (ReviewVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
