package com.first.ReportTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportSelectAllTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextLoads() {
		try {
			List<ReportVO> list = biz.get();
			for (ReportVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
