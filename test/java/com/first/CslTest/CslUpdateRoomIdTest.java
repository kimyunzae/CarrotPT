package com.first.CslTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ChatBiz;
import com.first.biz.CslBiz;
import com.first.vo.CslVO;

@SpringBootTest
class CslUpdateRoomIdTest {

	@Autowired
	CslBiz biz;
	
	@Autowired
	ChatBiz cbiz;
	
	@Test
	void contextloads() {
		CslVO obj = new CslVO(1000, 1000);
		try {
			cbiz.modifyroomid(obj);
			System.out.println("Updated: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
