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
public class MypageController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	//일반회원 마이페이지: 메인
	@RequestMapping("/mypage")
	public String mypage(Model m, String id) {
		try {
			TraineeVO vo = traineebiz.get(id);
			m.addAttribute("vo", vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "mypage/mypage");
		return "index";
	}

	
	//트레이너 마이페이지: 메인
	@RequestMapping("/trmypage")
	public String trmypage(Model m, HttpSession session) {	
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		m.addAttribute("trainercenter","mypage/trprofile");
		return "index";
	}
	
	//트레이너 마이페이지: 경력 및 수상
	@RequestMapping("/trcareer")
	public String trcareer(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter","mypage/trcareer");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return "index";
	}
	
	//트레이너 마이페이지: 이용내역 
		@RequestMapping("/trhistory")
		public String trhistory(Model m) {
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter","mypage/trhistory");
			return "index";
		}

}
