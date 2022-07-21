package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	@ModelAttribute("totalData")
	public int totalData() {
		int cnt = 0;
		try {
			cnt = traineebiz.getcnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@ModelAttribute("amount")
	public int amount() {
		int amount = 5;
		return amount;
	}
	
	// 관리자: 메인
	@RequestMapping("")
	public String admin(Model m, String orderBy) {
		int amount = 5;
		int pageNo = 1;
		int offset = 0;
		try {
			List<TraineeVO> list = traineebiz.getbypage(pageNo, amount, orderBy, offset);
			m.addAttribute("tneelist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/admin");
		m.addAttribute("admincenter", "admin/trainee");
		m.addAttribute("trainee_info", "admin/trainee_info");
		m.addAttribute("currentPage", pageNo);
		return "index";
	}
	
	@RequestMapping("/findpage")
	public String findPage(Integer pageNo, Model m, String orderBy) {
		
		int amount = 5;
		int offset = 0;
		List<TraineeVO> list = null;
		try {
			list = traineebiz.getbypage(pageNo, amount, orderBy, offset);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("tneelist", list);
		return "admin/trainee_info";
	}
	
	@RequestMapping("/trainees")
	public String directPage(Integer pageNo, String orderBy, Model m) {
		int amount = 5;
		int offset = 0;
		try {
			List<TraineeVO> list = traineebiz.getbypage(pageNo, amount, orderBy, offset);
			m.addAttribute("tneelist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/admin");
		m.addAttribute("admincenter", "admin/trainee");
		m.addAttribute("trainee_info", "admin/trainee_info");
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("orderBy", orderBy);
		return "index";
	}
	
	// 관리자: 일반회원 상세
	@RequestMapping("/trainees/detail")
	public String traineedetail(Model m, String id) {
		try {
			TraineeVO obj = traineebiz.get(id);
			m.addAttribute("vo", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "mypage/mypage");
		return "index";
	}
	
	// 관리자: 트레이너 조회
	@RequestMapping("/trainers")
	public String directPage(Model m) {
		m.addAttribute("center", "admin/admin");
		m.addAttribute("admincenter", "admin/trainer");
		m.addAttribute("trainer_info", "admin/trainer_info");
		return "index";
	}
	
	

}