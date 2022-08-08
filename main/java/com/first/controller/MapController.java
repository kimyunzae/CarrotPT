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

	/* 인덱스에서 지도로 찾기 하면 mapcenter2(임시) */
	@RequestMapping("/map")
	public String mapcenterloc(Model m) {
		m.addAttribute("center", "map/mapcenterloc");
		return "index";
	}
	
	/* nav bar에서 mapcenter */
	@RequestMapping("/mapsearch")
	public String mapsearch(Model m) {
		m.addAttribute("center", "map/mapcenter");
		return "index";
	}
	/* nav bar에서 maphttps://search.naver.com/search.naver?where=nexearch&sm=top_brd&fbm=0&ie=utf8&query=%EC%84%B8%EA%B3%84+%EA%B3%A0%EC%96%91%EC%9D%B4%EC%9D%98+%EB%82%A0center2 */
	@RequestMapping("/maploc")
	public String maploc(Model m) {
		m.addAttribute("center", "map/mapcenterloc");
		return "index";
	}
}
	

