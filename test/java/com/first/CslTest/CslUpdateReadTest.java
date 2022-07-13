package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;
import com.first.vo.CslVO;

@SpringBootTest
class CslUpdateReadTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		CslVO obj = new CslVO(1004, "대기중");
		try {
			biz.modifyread(obj);
			System.out.println("Updated: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
