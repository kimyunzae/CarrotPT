package com.first.WorkdayTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.WorkdayBiz;

@SpringBootTest
class WorkdayDeleteTest {

	@Autowired
	WorkdayBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(1007);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
