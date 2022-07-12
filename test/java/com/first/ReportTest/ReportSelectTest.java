package com.first.ReportTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportSelectTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextloads() {
		try {
			ReportVO obj = biz.get(1000);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
