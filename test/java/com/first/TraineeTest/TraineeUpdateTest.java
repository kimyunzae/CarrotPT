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

	// UPDATE trainee SET NAME=#{name},PHONE=#{phone},EMAIL=#{email},ZIP=#{zip},ADDR1=#{addr1},ADDR2=#{addr2} WHERE ID=#{id}

	@Test
	void contextLoads() {
		TraineeVO obj = new TraineeVO("id01", "공일잉","12341111", "abc@naver.com", "29112","선릉로21", null);
		try {
			biz.modify(obj);
			System.out.println("Update OK " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
