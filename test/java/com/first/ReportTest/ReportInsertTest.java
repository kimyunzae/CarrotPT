package com.first.ReportTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportInsertTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextloads() {
		ReportVO obj = new ReportVO("id06", "tid06", "욕설", "채팅 중 욕설 사용", null, null);
		try {
			biz.register(obj);
			System.out.println("Inserted" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
