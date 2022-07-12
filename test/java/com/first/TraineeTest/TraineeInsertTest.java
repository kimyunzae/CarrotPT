package com.first.TraineeTest;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;


@SpringBootTest
class TraineeInsertTest {
	
	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		TraineeVO obj = new TraineeVO("id09", "pwd09", "문설연", "01054131234", 
				"sym@naver.com","73213","선릉로25", null, null, "일반회원");
		try {
			biz.register(obj);
			System.out.println("Registered OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
