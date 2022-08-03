package com.first.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.ChatBot;

@Controller
public class ChatController {

	
	@Autowired
	ChatBot chatbot;
	
	@ResponseBody
	@RequestMapping("/sendMessage")
	public String sendMessage(String question) {
		String response = "";
		try {
			response = chatbot.getAnswer(question);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
