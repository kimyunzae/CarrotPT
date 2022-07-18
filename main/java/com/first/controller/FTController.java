package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;
	
	@ModelAttribute("totalCount")
	public int totalCount() {
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


	@RequestMapping("/")
	public String main(Model m) {
		
		try {
			List<TrainerVO> list = biz.getbypage(1, 6);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "trainers/trcenter");
		return "index";
	}
	
	@RequestMapping("/{pageNo}")
	public String findPage(@PathVariable("pageNo") int pageNo, Model m) {
		
		if(pageNo == 0) {
			pageNo = 1;
		}
		
		int amount = 6;
		List<TrainerVO> list = null;
		try {
			list = biz.getbypage(pageNo, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trcenter");
		m.addAttribute("trlist", list);
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
