package com.first.WorkdayTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.WorkdayBiz;
import com.first.vo.WorkdayVO;

@SpringBootTest
class WorkdayInsertTest {

	@Autowired
	WorkdayBiz biz;
	
	@Test
	void contextLoads() {
		WorkdayVO obj = new WorkdayVO("tid08", "12:00-17:00", "12:00-17:00", null, null, null, null, null);
		try {
			biz.register(obj);
			System.out.println("Inserted " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
