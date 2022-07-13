package com.first.Trainer;

import java.sql.Date;

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
		TrainerVO obj = new TrainerVO("tid13", "pwd13", "공일삼","010-1111-1112","abc13@naver.com","m","보디빌딩",
				"성신헬스10","00010","서울시 성북구",null,null,"경력10년입니다",null,null,null,
				"매칭완료",null,null,null,null,"date","트레이너");
		try {
			biz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
