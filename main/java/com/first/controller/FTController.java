package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@RequestMapping("/")
	public String main(Model m) {
		m.addAttribute("center", "trainers/center");
		return "index";
	}
}
