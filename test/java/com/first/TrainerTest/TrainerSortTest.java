package com.first.TrainerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.biz.TrainerSort;
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
		String loc = null;
		String major = null;
		try {
			trainerList = biz.getauthorized(loc, major);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------Before Sort--------");
		for (TrainerVO trainerVO : trainerList) {
			System.out.println(trainerVO);
		}
		
		TrainerSort.sortTrainer(trainerList, "rvcnt");
		System.out.println("-------After Sort--------");
		for (TrainerVO trainerVO : trainerList) {
			System.out.println(trainerVO);
		}
		
	}

}