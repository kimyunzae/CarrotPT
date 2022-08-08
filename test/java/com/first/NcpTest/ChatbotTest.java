package com.first.NcpTest;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.ChatBot;

@SpringBootTest
class ChatbotTest {
	
	@Autowired
	ChatBot Chatbot;

	@Test
	void contextLoads() throws IOException {
		String question = "당근PT가 뭐야";
		String answer = Chatbot.getAnswer(question);
		System.out.println("Q. " + question);
		System.out.println("A. " + answer);
	}
	
	@Test
	void contextLoads1() throws IOException {
		String question = "운동관련해서 문의하고싶어";
		String answer = Chatbot.getAnswer(question);
		System.out.println("Q. " + question);
		System.out.println("A. " + answer);
	}
	
	@Test
	void contextLoads2() throws IOException {
		String question = "당근pt 운영진에게 상담하고 싶어요";
		String answer = Chatbot.getAnswer(question);
		System.out.println("Q. " + question);
		System.out.println("A. " + answer);
	}
	
	@Test
	void contextLoads3() throws IOException {
		String question = "환불하고 싶어요";
		String answer = Chatbot.getAnswer(question);
		System.out.println("Q. " + question);
		System.out.println("A. " + answer);
	}
	
}
