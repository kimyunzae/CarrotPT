package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "user/login");
		return "index";
	}
	
	@RequestMapping("/join")
	public String join(Model m) {
		m.addAttribute("center", "user/join");
		return "index";
	}
	
	@RequestMapping("/join/trainer")
	public String trainerjoin(Model m) {
		m.addAttribute("center", "user/trainerjoin");
		return "index";
	}
	
	@RequestMapping("/join/trainee")
	public String traineejoin(Model m) {
		m.addAttribute("center", "user/traineejoin");
		return "index";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "user/mypage");
		return "index";
	}
	
	@RequestMapping("/tmypage")
	public String tmypage(Model m) {
		m.addAttribute("center", "user/tmypage");
		return "index";
	}
}
