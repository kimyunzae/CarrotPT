package com.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.ReportBiz;
import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.NewAlarmVO;
import com.first.vo.ReportVO;
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
	
	@Autowired
	ReportBiz reportbiz;
	

	@Value("5")
	private int amount;
	
	@ModelAttribute("amount")
	public int addAmount() {
		return amount;
	}
	
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
	
	@ModelAttribute("newAlarmCnt")
	public NewAlarmVO newalarms(String tstatus, String rstatus) {
		tstatus = "대기중";
		rstatus = "대기중";
		NewAlarmVO obj = null;
		try {
			obj = reportbiz.selectalarms(tstatus, rstatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	};
	
	// 1-1 메인: 일반회원 조회
	@RequestMapping("")
	public String admin(Model m, String orderBy, Integer pageNo, HttpSession session) {
		String result = "";
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			result = "redirect:/";
		}else {
			if(pageNo == null) {
				pageNo = 1;
			}
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
			result = "index";
		}
		
		return result;
	}
	
	// 1-2 일반회원 pagination
	@RequestMapping("/findpage")
	public String findPage(Integer pageNo, Model m, String orderBy) {
		
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
	public String traineedetail(Model m, String id, HttpSession session) {
		String result = "";
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			result = "redirect:/";
		}else {
			try {
				TraineeVO obj = traineebiz.get(id);
				m.addAttribute("vo", obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "mypage/mypage");
			result = "index";
		}
		return result;
	}
	
	// 2-1 트레이너 조회
	@RequestMapping("/trainers")
	public String directPage(Model m, Integer pageNo, String orderBy, String status, HttpSession session) {
		String result = "";
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			result = "redirect:/";
		}else {
			if(pageNo == null) {
				pageNo = 1;
			}
			
			if(status == null) {
				status = "all";
			}
			try {
				List<TrainerVO> list = trainerbiz.getbypage(pageNo, amount, orderBy, status);
				m.addAttribute("tnerlist", list);
				List<StatusVO> statuslist = trainerbiz.getstatus();
				m.addAttribute("statuslist", statuslist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("statusforpage", status);
			m.addAttribute("center", "admin/admin");
			m.addAttribute("admincenter", "admin/trainer");
			m.addAttribute("trainer_info", "admin/trainer_info");
			m.addAttribute("currentPage", pageNo);
			result = "index";
		}
		return result;
	}
	
	// 2-2 트레이너 pagination
	@RequestMapping("/findtpage")
	public String findtPage(int pageNo, String orderBy, String status, Model m, HttpSession session) {
		try {
			List<TrainerVO> list = trainerbiz.getbypage(pageNo, amount, orderBy, status);
			m.addAttribute("tnerlist", list);
			List<StatusVO> statuslist = trainerbiz.getstatus();
			m.addAttribute("statuslist", statuslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("statusforpage", status);
		m.addAttribute("currentPage", pageNo);
		return "admin/trainer_info";
	}
	
	// 2-3 트레이너 상세
	@RequestMapping("/trainers/detail")
	public String trainerdetail(Model m, String id, HttpSession session) {
		String result = "";
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			result = "redirect:/";
		}else {
			try {
				TrainerVO obj = trainerbiz.get(id);
				m.addAttribute("trainer", obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter","mypage/trprofile");
			result =  "index";
		}
		return result;
	}
	
	// 2-4 트레이너 status 업데이트
	@ResponseBody
	@RequestMapping("/updatestatus")
	public void updateStatus(String id, String newstatus, String statusdetail) {
		TrainerVO obj = new TrainerVO(id, newstatus, statusdetail);
		try {
			trainerbiz.modifystatus(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3-1 신고 조회
	@RequestMapping("/reports")
	public String reports(Model m, HttpSession session) {
		String result = "";
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			result = "redirect:/";
		}else {
			try {
				List<ReportVO> list = reportbiz.get();
				m.addAttribute("reportlist", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "admin/admin");
			m.addAttribute("admincenter", "admin/report");
			m.addAttribute("report_info", "admin/report_info");
			result = "index";
		}
		return result;
	}
	
	// 3-3 신고 status 업데이트
	@ResponseBody
	@RequestMapping("/updateReportStatus")
	public void updateReportStatus(int id, String rp_status) {
		ReportVO obj = new ReportVO(id, rp_status);
		try {
			reportbiz.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
