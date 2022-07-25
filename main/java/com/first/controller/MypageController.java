package com.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.frame.Util;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class MypageController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	@Value("${dir1}")
	String dir1;

	
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
	
	//일반회원 마이페이지 업데이트
		@RequestMapping("/updateimpl")
		public RedirectView updateimpl(Model m, TraineeVO trainee) {
			try {
				traineebiz.modify(trainee);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new RedirectView("/mypage");
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
	
	//트레이너 대표프로필 변경
//		@RequestMapping("/updateprofile1")
//		public RedirectView updateprofile1(Model m, TrainerVO trainer) {
//			String profile1 = trainer.getPf1().getOriginalFilename();
//			if(!(profile1.equals(""))) {
//				trainer.setProfile1(profile1);
//				Util.saveFile(trainer.getPf1(),dir1);
//				}
//			try {
//				trainerbiz.modifyProfile1(trainer);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return new RedirectView("/trmypage");
//		}
		
	// 트레이너 계정정보 업데이트
	@RequestMapping("/trprofile_update")
	public RedirectView trprofile_update(Model m, TrainerVO vo) {
		try {
			trainerbiz.modify(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("/trmypage");
	}
	
	
	//트레이너 마이페이지: 경력 및 수상
	@RequestMapping("/traccount")
	public String trprofile(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter","mypage/traccount");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return "index";
	}
	
	//트레이너 마이페이지: 매칭신청
	@RequestMapping("/trmatching")
	public String trmatching(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter","mypage/trmatching");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return "index";
	}
			
	
	//트레이너 마이페이지: 이용내역 
		@RequestMapping("/trhistory")
		public String trhistory(Model m, HttpSession session) {
			try {
				TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
				m.addAttribute("center", "mypage/trmypage");
				m.addAttribute("trainercenter","mypage/trhistory");
				m.addAttribute("trainer", trainer);

			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			return "index";
		}

}
