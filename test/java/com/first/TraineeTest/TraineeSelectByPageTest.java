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
		int pageNo = 1;
		int amount = 6;
		String orderBy = null;
		try {
			List<TraineeVO> list = biz.getbypage(pageNo, amount, orderBy);
			for (TraineeVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
