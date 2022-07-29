package com.first.TrainerTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.biz.TrainerSort;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerPreferenceTest {

	@Autowired
	TrainerBiz biz;
	
	@Autowired
	TrainerSort TrainerSort;

	@Test
	void contextLoads() {
		String gender = "여";
		String zip = "50000";
		String[] workday = new String[] {"mon", "tue", "wed"};
		try {
			List<TrainerVO> list = biz.getforpreference(gender, zip, workday);
			
			TrainerSort.sortTrainer(list, "preference");
			for (TrainerVO trainerVO : list) {
				System.out.println(trainerVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
