package com.first.TrainerTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.MajorVO;

@SpringBootTest
class TrainerSelectMajorTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		try {
			List<MajorVO> list = biz.getmajor();
			for (MajorVO obj : list) {
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
