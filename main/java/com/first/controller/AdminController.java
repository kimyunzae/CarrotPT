package com.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class AdminController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	// 관리자: 메인
	@RequestMapping("/admin")
	public String admin(Model m, String id) {
		try {
			List<TraineeVO> list = traineebiz.gettrainees();
			m.addAttribute("tneelist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/admin");
		m.addAttribute("admincenter", "admin/admintrainee");
		return "index";
	}
	
	// 관리자: 일반회원 상세
	@RequestMapping("/admin/trainees")
	public String traineedetail(Model m, String id) {
		try {
			TraineeVO obj = traineebiz.get(id);
			m.addAttribute("vo", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/mypage");
		return "index";
	}

}
