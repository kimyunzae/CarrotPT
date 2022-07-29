package com.first.WorkdayTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.WorkdayBiz;
import com.first.vo.WorkdayVO;

@SpringBootTest
class WorkdaySelectAllTest {

	@Autowired
	WorkdayBiz biz;
	
	@Test
	void contextLoads() {
		try {
			List<WorkdayVO> list = biz.get();
			for (WorkdayVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
