package com.first.MapTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.MapBiz;
import com.first.vo.MapVO;

@SpringBootTest
class MapSelectAllTest {
	
	@Autowired
	MapBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<MapVO> list = biz.get();
			for (MapVO mapVO : list) {
				System.out.println(mapVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
