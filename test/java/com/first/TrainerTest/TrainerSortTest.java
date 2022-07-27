package com.first.TrainerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.frame.TrainerSort;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSortTest {

	@Autowired
	TrainerBiz biz;
	
	@Autowired
	TrainerSort TrainerSort;

	@Test
	void contextLoads() {
		List<TrainerVO> trainerList = new ArrayList<TrainerVO>();
		try {
			trainerList = biz.getauthorized();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------Before Sort--------");
		for (TrainerVO trainerVO : trainerList) {
			System.out.println(trainerVO);
		}
		
		TrainerSort.sortTrainer(trainerList, "num");
		System.out.println("-------After Sort--------");
		for (TrainerVO trainerVO : trainerList) {
			System.out.println(trainerVO);
		}
		
	}

}
