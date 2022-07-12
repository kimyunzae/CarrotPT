package com.first.TraineeTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@SpringBootTest
class TraineeUpdateTest {
	
	@Autowired
	TraineeBiz biz;

	//	UPDATE trainee SET PWD=#{pwd},NAME=#{name},PHONE=#{phone},EMAIL=#{email},ZIP=#{zip},ADDR1=#{addr1},ADDR2=#{addr2},LEVEL=#{level} WHERE UID=#{uid}
	@Test
	void contextLoads() {
		TraineeVO obj = new TraineeVO("id08", "pwd8","홍지훈","01012312412", "abc@naver.com", "29112","선릉로21", null,"일반회원");
		try {
			biz.modify(obj);
			System.out.println("Update OK");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
