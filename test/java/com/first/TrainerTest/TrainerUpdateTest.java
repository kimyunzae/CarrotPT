package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerUpdateTest {
	
	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		TrainerVO obj = new TrainerVO("dsa","pwd112","010-1111-2222",
				"abcd@naver.com","m","필라테스","바뀜헬스","10012",
				"서울시 성북구","정릉로","운잘알입니다",
				"경력3년","license11.img","license12.img","license13.img",
				"대기중","자격불충족","profile11.img","profile12.img","profile13.img",
				"트레이너");
		try {
			biz.modify(obj);
			System.out.println("update OK"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
