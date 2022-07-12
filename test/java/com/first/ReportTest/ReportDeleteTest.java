package com.first.ReportTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;

@SpringBootTest
class ReportDeleteTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(1004);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
