package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;

@SpringBootTest
class CslDeleteTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		try {
			biz.remove(1001);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
