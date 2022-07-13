package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;
import com.first.vo.CslVO;

@SpringBootTest
class CslSelectTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		try {
			CslVO obj = biz.get(1002);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
