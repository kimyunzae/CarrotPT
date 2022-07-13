package com.first.CslTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.frame.StringToDateConverter;


@SpringBootTest
class CslInsertTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		
		Date d = StringToDateConverter.convert("2022-07-13");
			
	}
}
