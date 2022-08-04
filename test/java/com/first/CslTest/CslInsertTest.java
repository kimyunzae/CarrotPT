package com.first.CslTest;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.frame.StringToDateConverter;
import com.first.vo.CslVO;


@SpringBootTest
class CslInsertTest {

	@Autowired
	CslBiz biz;
	
	@Autowired
	StringToDateConverter convert;
	
	@Test
	void contextloads() {
		Date d = convert.convert("2022-07-13");
		CslVO obj = new CslVO("id06", "tid22", "월, 금, 토", d, "15:00", null);
		try {
			biz.register(obj);
			System.out.println("Inserted: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
