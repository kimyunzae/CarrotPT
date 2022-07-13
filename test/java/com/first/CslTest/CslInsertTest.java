package com.first.CslTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.vo.CslVO;


@SpringBootTest
class CslInsertTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		
		String d= "2022-07-13";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			
			date = format.parse(d);
			CslVO obj= new CslVO("id01","tid01","토,일",date, "14:00");
			try {
				biz.register(obj);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println("Inserted" + obj);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
			
	}
}
