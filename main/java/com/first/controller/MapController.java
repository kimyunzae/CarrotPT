package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/map")
public class MapController {
	
	@RequestMapping("/")
	public String main(Model m) {
		m.addAttribute("center", "map/mapcenter");
		return "index";
	}
}
