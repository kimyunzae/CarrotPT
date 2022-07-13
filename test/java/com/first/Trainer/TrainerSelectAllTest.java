package com.first.Trainer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectAllTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		try {
			List<TrainerVO> list = biz.get();
			for (TrainerVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
