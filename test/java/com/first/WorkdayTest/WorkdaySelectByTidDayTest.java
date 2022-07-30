package com.first.WorkdayTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.WorkdayBiz;
import com.first.vo.WorkdayVO;

@SpringBootTest
class WorkdaySelectByTidDayTest {

	@Autowired
	WorkdayBiz biz;
	
	@Test
	void contextLoads() {
		try {
			WorkdayVO obj = biz.getbytidday("wed", "tid01");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
