package com.first.TrainerTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.StatusVO;

@SpringBootTest
class TrainerSelectStatusTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		try {
			List<StatusVO> list = biz.getstatus();
			for (StatusVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
