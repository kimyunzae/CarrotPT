package com.first.biz;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.first.mapper.TraineeMapper;
import com.first.mapper.TrainerMapper;

@Service
public class MailBiz {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	TraineeMapper traineedao;
	
	@Autowired
	TrainerMapper trainerdao;
	
	public int randompwd() {
		Random random = new Random();
		int randompwd = random.nextInt(999999) + 100000;
		return randompwd;
	}
	
	public void sendMail(String recipient) {
		ArrayList<String> toUserList = new ArrayList<>();
		toUserList.add(recipient);
		int toUserSize = toUserList.size();
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo((String[])toUserList.toArray(new String[toUserSize]));
		simpleMessage.setSubject("당근PT 임시 비밀번호가 발급되었습니다.");
		
		
		simpleMessage.setText("임시 비밀번호는");
	}
}
