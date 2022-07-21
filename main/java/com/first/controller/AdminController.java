package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.StatusVO;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

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
	
	@ModelAttribute("TrainerTotal")
	public int trainertotal(String status) {
		int cnt = 0;
		try {
			cnt = trainerbiz.getcnt(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 1-1 메인: 일반회원 조회
	@RequestMapping("")
	public String admin(Model m, String orderBy, Integer pageNo) {
		if(pageNo == null) {
			pageNo = 1;
		}
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
		return "index";
	}
	
	// 1-2 일반회원 pagination
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
	
	
	// 1-3 일반회원 상세
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
	
	// 2-1 트레이너 조회
	@RequestMapping("/trainers")
	public String directPage(Model m, Integer pageNo, String orderBy, String status) {
		
		if(pageNo == null) {
			pageNo = 1;
		}
		int amount = 5;
		int offset = 0;
		try {
			List<TrainerVO> list = trainerbiz.getbypage(pageNo, amount, orderBy, offset, status);
			m.addAttribute("tnerlist", list);
			List<StatusVO> statuslist = trainerbiz.getstatus();
			m.addAttribute("statuslist", statuslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/admin");
		m.addAttribute("admincenter", "admin/trainer");
		m.addAttribute("trainer_info", "admin/trainer_info");
		m.addAttribute("currentPage", pageNo);
		return "index";
	}
	
	// 2-2 트레이너 pagination
	@RequestMapping("/findtpage")
	public String findtPage(int pageNo, String orderBy, String status, Model m) {
		
		int amount = 5;
		int offset = 0;
		try {
			List<TrainerVO> list = trainerbiz.getbypage(pageNo, amount, orderBy, offset, status);
			m.addAttribute("tnerlist", list);
			List<StatusVO> statuslist = trainerbiz.getstatus();
			m.addAttribute("statuslist", statuslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("currentPage", pageNo);
		return "admin/trainer_info";
	}
	
	// 2-3 트레이너 상세
	@RequestMapping("/trainers/detail")
	public String trainerdetail(Model m, String id) {
		try {
			TrainerVO obj = trainerbiz.get(id);
			m.addAttribute("trainer", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "mypage/trmypage");
		m.addAttribute("trainercenter","mypage/trprofile");
		return "index";
	}
	
	// 2-4 트레이너 status 업데이트
	@ResponseBody
	@RequestMapping("/updatestatus")
	public void updateStatus(String id, String newstatus) {
		TrainerVO obj = new TrainerVO(id, newstatus);
		try {
			trainerbiz.modifystatus(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
