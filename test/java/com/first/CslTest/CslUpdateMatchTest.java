package com.first.CslTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.vo.CslVO;

@SpringBootTest
class CslUpdateMatchTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		CslVO obj = new CslVO(1015, "대기중");
		try {
			biz.modifymatch(obj);
			System.out.println("Updated: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
