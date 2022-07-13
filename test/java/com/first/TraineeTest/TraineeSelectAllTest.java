package com.first.TraineeTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@SpringBootTest
class TraineeSelectAllTest {

	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		List<TraineeVO> list = null;
		try {
			list = biz.get();
			System.out.println("SelectAll OK");
			for (TraineeVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
