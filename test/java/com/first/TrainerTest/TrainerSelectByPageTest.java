package com.first.TrainerTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectByPageTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		int pageNo = 1;
		int amount = 6;
		String orderBy = null;
		String status = null;
		try {
			int offset = 0;
			List<TrainerVO> list = biz.getbypage(pageNo, amount, orderBy, offset, status);
			for (TrainerVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
