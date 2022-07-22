package com.first.ReportTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportSelectCntTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		String status = "처리완료";
		try {
			cnt = biz.getcnt(status);
			System.out.println("status: " + status + " cnt: " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
