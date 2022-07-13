package com.first.CslListTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslListBiz;
import com.first.vo.CslListVO;

@SpringBootTest
class CslListUpdateTest {
	
	@Autowired
	CslListBiz biz;
	
	@Test
	void contextLoads() {
		CslListVO obj = new CslListVO(1002, "10대", "응답하지 않음", "재활", "아예 안해요");
		try {
			biz.modify(obj);
			System.out.println("Updated: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
