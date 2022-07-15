package com.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@RestController
public class AJAXController {

	@Autowired
	TraineeBiz traineebiz;
	
	@Autowired
	TrainerBiz tbiz;

	@RequestMapping("checkid")
	public String checkid(String id) {
		String result = "";
		TraineeVO ie = null;
		
		if (id.equals("") || id == null) {
			result = "1";
		}

		try {
			ie = traineebiz.get(id);
			if(ie == null) {
				result = "0";
			}else {
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
			result = "1";
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

	
// ====================================== 트레이너 회원가입 ===========================================
	@RequestMapping("checktid")
	public String checktid(String id) {
		String result = "";
		TrainerVO i = null;

		if (id.equals("") || id == null) {
			result = "1";
		}

		try {
			i = tbiz.get(id);
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
	
	@RequestMapping("checktemail")
	public String checktemail(String email) {
		String result = "";
		TrainerVO i = null;

		if (email.equals("") || email == null) {
			result = "1";
		}

		try {
			i = tbiz.getbyemail(email);
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

}
