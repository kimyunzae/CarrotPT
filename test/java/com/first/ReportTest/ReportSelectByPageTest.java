package com.first.ReportTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ReportBiz;
import com.first.vo.ReportVO;

@SpringBootTest
class ReportSelectByPageTest {

	@Autowired
	ReportBiz biz;
	
	@Test
	void contextLoads() {
		int pageNo = 1;
		int amount = 10;
		String rp_status = "대기중";
		try {
			List<ReportVO> list = biz.getbypage(pageNo, amount, rp_status);
			for (ReportVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
