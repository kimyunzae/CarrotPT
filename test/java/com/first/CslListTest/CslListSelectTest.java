package com.first.CslListTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslListBiz;
import com.first.vo.CslListVO;

@SpringBootTest
class CslListSelectTest {
	
	@Autowired
	CslListBiz biz;
	
	@Test
	void contextLoads() {
		try {
			CslListVO obj = biz.get(1000);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
