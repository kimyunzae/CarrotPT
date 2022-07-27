package com.first.biz;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailBiz {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public String randompwd() {
		Random random = new Random();
		int randompwd = random.nextInt(899999) + 100000;
		String newpwd = Integer.toString(randompwd);
		return newpwd;
	}
	
	public void sendmail(String recipient, String newpwd) {
		ArrayList<String> toUserList = new ArrayList<>();
		toUserList.add(recipient);
		int toUserSize = toUserList.size();
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo((String[])toUserList.toArray(new String[toUserSize]));
		simpleMessage.setSubject("당근PT 임시 비밀번호가 발급되었습니다.");
		simpleMessage.setText("임시 비밀번호는 [" + newpwd + "]입니다.");
		javaMailSender.send(simpleMessage);
	}
}
