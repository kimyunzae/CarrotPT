package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;
import com.first.vo.CslVO;

@SpringBootTest
class CslUpdateTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		CslVO obj = new CslVO("id02", "tid02", "화,목", null, "17:00");
		try {
			biz.modify(obj);
			System.out.println("Updated" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
