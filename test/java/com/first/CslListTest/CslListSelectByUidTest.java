package com.first.CslListTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslListBiz;
import com.first.vo.CslListVO;

@SpringBootTest
class CslListSelectByUidTest {
	
	@Autowired
	CslListBiz biz;
	
	@Test
	void contextLoads() {
		try {
			List<CslListVO> list = biz.getbyuid("id01");
			for (CslListVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
