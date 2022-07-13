package com.first.CslListTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslListBiz;
import com.first.vo.CslListVO;

@SpringBootTest
class CslListDeleteTest {
	
	@Autowired
	CslListBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(1003);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
