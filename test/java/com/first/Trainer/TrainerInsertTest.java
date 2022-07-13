package com.first.Trainer;

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
		TrainerVO obj = new TrainerVO("tid14","pwd14","공일사","010-1111-1114","abc14@naver.com","m","크로스핏",
				"성신헬스14","00014","서울시 성북구","경력5년이상","date");
		try {
			biz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
