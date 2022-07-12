package com.first.WorkdayTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.WorkdayBiz;
import com.first.vo.WorkdayVO;

@SpringBootTest
class WorkdayUpdateTest {

	@Autowired
	WorkdayBiz biz;
	
	@Test
	void contextLoads() {
		WorkdayVO obj = new WorkdayVO("tid08", null, null, null, null, null, null, null);
		try {
			biz.modify(obj);
			System.out.println("Updated" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
