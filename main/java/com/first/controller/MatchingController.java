package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatchingController {

	@RequestMapping("/matching")
	public String matching(Model m) {
//		m.addAttribute("center", "matching/matching");
		return "matching/matching";
	}
}
