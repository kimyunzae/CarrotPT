package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.TrainerBiz;
import com.first.vo.MajorVO;
import com.first.vo.TrainerVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;
	
	@ModelAttribute("totalData")
	public int totalData() {
		int cnt = 0;
		try {
			cnt = biz.getcnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@ModelAttribute("amount")
	public int amount() {
		int amount = 6;
		return amount;
	}
	
	@ModelAttribute("majors")
	public List<MajorVO> majors(){
		List<MajorVO> list = null;
		try {
			list = biz.getmajor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@RequestMapping("/")
	public String main(Model m) {
		int amount = 6;
		int pageNo = 1;
		try {
			List<TrainerVO> list = biz.getbypage(pageNo, amount);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "trainers/trcenter");
		m.addAttribute("trcenter_info", "trainers/trcenter_info");
		m.addAttribute("currentPage", pageNo);
		return "index";
	}
	
//	@ResponseBody
//	@GetMapping("/list")
//	public ModelAndView findPage(int pageNo) {
//		ModelAndView mv = new ModelAndView();
//		int amount = 6;
//		List<TrainerVO> list = null;
//		try {
//			list = biz.getbypage(pageNo, amount);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// m.addAttribute("center", "trainers/trcenter");
//		mv.addObject("trlist", list);
//		mv.addObject("currentPage", pageNo);
//		System.out.println(list);
//		mv.setViewName("trainers/trcenter_info");
//		return mv;
//	}
	
	
	@RequestMapping("/findpage")
	public String findPage(int pageNo, Model m) {
		int amount = 6;
		List<TrainerVO> list = null;
		try {
			list = biz.getbypage(pageNo, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("trlist", list);
		return "trainers/trcenter_info";
	}
	
	@RequestMapping("/list")
	public String directPage(int pageNo, Model m) {
		System.out.println("Direct");
		int amount = 6;
		try {
			List<TrainerVO> list = biz.getbypage(pageNo, amount);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "trainers/trcenter");
		m.addAttribute("trcenter_info", "trainers/trcenter_info");
		m.addAttribute("currentPage", pageNo);
		return "index";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, String id) {
		try {
			TrainerVO obj = biz.get(id);
			m.addAttribute("dtrainer", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trdetail");
		return "index";
	}

}
