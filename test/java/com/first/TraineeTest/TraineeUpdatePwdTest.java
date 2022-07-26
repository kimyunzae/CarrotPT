package com.first.TraineeTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@SpringBootTest
class TraineeUpdatePwdTest {
	
	@Autowired
	TraineeBiz biz;

	@Test
	void contextLoads() {
		String email = "dsad";
		String pwd = "newpwd";
		try {
			biz.updatepwd(email, pwd);
			System.out.println("Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
