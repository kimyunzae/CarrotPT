package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/map")
public class MapController {

	/*
	 * @RequestMapping("/map") public String mapcenter(Model m) {
	 * m.addAttribute("center", "map/mapcenter"); return "index"; }
	 */

	/* 인덱스에서 지도로 찾기 하면 mapcenter2(임시) */
	@RequestMapping("")
	public String mapmain(Model m) {
		m.addAttribute("center", "map/mapcenter2");
		return "index";
	}
	
	/* nav bar에서 mapcenter */
	@RequestMapping("/search")
	public String mapsearch(Model m) {
		m.addAttribute("center", "map/mapcenter");
		return "index";
	}

}
