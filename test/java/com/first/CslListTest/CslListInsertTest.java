package com.first.CslListTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslListBiz;
import com.first.vo.CslListVO;

@SpringBootTest
class CslListInsertTest {
	
	@Autowired
	CslListBiz biz;
	
	@Test
	void contextLoads() {
		CslListVO obj = new CslListVO("id06", "응답 없음", "남성", "체중 감량", "주 1-2회");
		try {
			biz.register(obj);
			System.out.println("Inserted: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
