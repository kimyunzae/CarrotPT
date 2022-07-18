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
		TrainerVO obj = new TrainerVO("tid36", "pwd36", "김명원", "01036363636", "kmw@gmail.com", "f", "헬스", "무원짐", "60121", "서울특별시 성북구", "1층", "요가마나옴입니다", "생활체육지도사", "license.jpg", null, null, "profile.jpg", null, null);
		try {
			biz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
