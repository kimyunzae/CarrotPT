package com.first.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.WebSocketSession;

import com.first.biz.CslBiz;
import com.first.vo.ChatMessageVO;
import com.first.vo.CslVO;

@Controller
public class MatchingController {
	
	@Autowired
	CslBiz biz;
	
	@ModelAttribute("cslList")
	public List<CslVO> cslList(HttpSession session){
		List<CslVO> list = null;
		String id = session.getAttribute("custid").toString();

		try {
			list = biz.getlistbyid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

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
	
	@MessageMapping("/{roomId}")
	@SendTo("/room/{roomId}")
	public ChatMessageVO sendChat(@DestinationVariable int roomId, ChatMessageVO message) {
		ChatMessageVO obj = new ChatMessageVO(message.getMessageType(), roomId, message.getSender(), message.getMessage());
		
//		if(message.getMessageType().equals(ChatMessageVO.MessageType.ENTER)) {
//			sessions.setAttribute(, socketSession); // HttpSession에 HashSet 저장 가능? 방별로 다른 HashSet을 만들어야 하는지?
//		}
		
		System.out.println(obj);
		return obj;
	}
}
