package com.first.MailTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.MailBiz;

@SpringBootTest
class MailSendMailTest {

	@Autowired
	MailBiz biz;
	
	@Test
	void contextLoads() {
		String recipient = null;
		biz.sendmail(recipient);
	}
}
