package com.first.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MatchingController {

	@RequestMapping("/matching")
	public String matching(Model m, HttpSession session) {
		String result = "";
		Object cust = session.getAttribute("logincust");
		if(cust == null) {
			result = "redirect:/";
		}else {
			m.addAttribute("logincust", cust);
			result = "matching/matching";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/getTime")
	public String gettime() {
		JSONArray currentArr = new JSONArray();
		JSONObject currentObj = new JSONObject();
		LocalDateTime now = LocalDateTime.now();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		int date = now.getDayOfMonth();
		int day = now.getDayOfWeek().getValue();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		currentObj.put("year", year);
		currentObj.put("month", month);
		currentObj.put("date", date);
		currentObj.put("day", day);
		currentObj.put("hour", hour);
		currentObj.put("minute", minute);
		currentObj.put("second", second);
		
		currentArr.put(currentObj);
		return currentArr.toString();
	}
}
