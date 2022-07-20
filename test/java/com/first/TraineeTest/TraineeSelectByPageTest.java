package com.first.TraineeTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@SpringBootTest
class TraineeSelectByPageTest {

	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		int pageNo = 2;
		int amount = 6;
		String orderBy = null;
		try {
			int offset = 0;
			List<TraineeVO> list = biz.getbypage(pageNo, amount, orderBy, offset);
			for (TraineeVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
