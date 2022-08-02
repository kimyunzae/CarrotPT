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
}
