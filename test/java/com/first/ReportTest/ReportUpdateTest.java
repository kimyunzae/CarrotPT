package com.first.ReportTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportUpdateTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextLoads() {
		ReportVO obj = new ReportVO(1000, "처리완료");
		try {
			biz.modify(obj);
			System.out.println("Updated" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
