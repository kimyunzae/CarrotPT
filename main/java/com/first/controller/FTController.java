package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.biz.TrainerSort;
import com.first.vo.MajorVO;
import com.first.vo.TrainerVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;
	
	@Autowired
	TrainerSort trainersort;
	
	@ModelAttribute("totalData")
	public int totalData() {
		int cnt = 0;
		try {
			cnt = biz.getcnt("수락");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Value("6")
	private int amount;
	
	
	@ModelAttribute("amount")
	public int addAmount() {
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


	@RequestMapping("")
	public String main(Model m, Integer pageNo, String orderBy) {
		
		if(pageNo == null) {
			pageNo = 1;
		}
		
		if(orderBy == null) {
			orderBy = "num";
		}
		
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		String status = "수락";
		
		try {
			List<TrainerVO> list = biz.getauthorized();
			
			trainersort.sortTrainer(list, orderBy);
			cnt = biz.getcnt(status);
			
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			
			list = list.subList(startIndex, endIndex);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trcenter");
		m.addAttribute("trcenter_info", "trainers/trcenter_info");
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("orderBy", orderBy);
		return "index";
	}
	
	
	@RequestMapping("/findpage")
	public String findPage(Model m, int pageNo, String orderBy) {
		
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		String status = "수락";
		
		try {
			List<TrainerVO> list = biz.getauthorized();
			
			trainersort.sortTrainer(list, orderBy);
			cnt = biz.getcnt(status);
			
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			
			list = list.subList(startIndex, endIndex);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("currentPage", pageNo);
		return "trainers/trcenter_info";
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
