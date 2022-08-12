package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;
import com.first.vo.CslVO;

@SpringBootTest
class CslCheckMatchingTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		try {
			String matching_status = biz.checkmatching("id01", "tid01");
			System.out.println(matching_status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
