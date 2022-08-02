package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

	/*
	 * @RequestMapping("/map") public String mapcenter(Model m) {
	 * m.addAttribute("center", "map/mapcenter"); return "index"; }
	 */
	@RequestMapping("/map")
	public String mapcenter(Model m) {
		m.addAttribute("center", "map/mapcenter2");
		return "index";
	}
}
