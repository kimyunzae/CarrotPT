package com.first.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.MapBiz;
import com.first.vo.MapVO;

@Controller

@RequestMapping("/map")
public class MapController {
	
	@Autowired
	MapBiz biz;

	/*
	 * @RequestMapping("/map") public String mapcenter(Model m) {
	 * m.addAttribute("center", "map/mapcenter"); return "index"; }
	 */

	/* 인덱스에서 지도로 찾기 하면 mapcenter2(임시) */

	@RequestMapping("")
	public String mapmain(Model m) {
		m.addAttribute("center", "map/mapcenterloc");
		return "index";
	}
	
	/* nav bar에서 mapcenter */
	@RequestMapping("/search")
	public String mapsearch(Model m) {
		m.addAttribute("center", "map/mapcenter");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getpositions")
	public Object getpositions() {
		JSONArray positionArr = new JSONArray();
		try {
			List<MapVO> positionList = biz.get();
			for (MapVO marker : positionList) {
				JSONObject positionObj = new JSONObject();
				positionObj.put("gymname", marker.getGymname());
				positionObj.put("lat", marker.getLat());
				positionObj.put("lng", marker.getLng());
				positionArr.add(positionObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

}
	

