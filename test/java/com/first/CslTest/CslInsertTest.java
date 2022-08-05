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
		Date d = convert.convert("2022-09-13");
		CslVO obj = new CslVO("id07", "tid35", "수, 목", d, "12:00", "20대", "여성", "재활", "일주일에 2-3번");
		try {
			biz.register(obj);
			System.out.println("Inserted: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
