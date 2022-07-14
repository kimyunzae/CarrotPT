package com.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@RestController
public class AJAXController {

	@Autowired
	TraineeBiz traineebiz;
	
	@RequestMapping("checkid")
	public String checkid(String id) {
		
		String result = "";
		TraineeVO ie = null;
		
		if(id.equals("") || id == null) {
			return "1";
		}
		
		try {
			ie = traineebiz.get(id);
			if(ie == null) {
				result = "0";
			}else{
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("checkemail")
	public String checkemail(String email) {
		String result = "";
		TraineeVO i = null;

		if (email.equals("") || email == null) {
			return "1";
		}

		try {
			i = traineebiz.getbyemail(email);
			if (i == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	회원가입 성공 시 joinok page 띄우기
//	@RequestMapping("/join_formimpl")
//	public String join_formimpl(Model m,String id, String pwd) {
//	System.out.println(id+""+pwd);
//	m.addAttribute("center","ajax/registerok");
//	m.addAttribute("left","ajax/left");
//		return "main";	
//	}
		
}








