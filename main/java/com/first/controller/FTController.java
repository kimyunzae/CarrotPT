package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;

	@RequestMapping("/")
	public String main(Model m) {
		
		int cnt = 0;
		try {
			List<TrainerVO> list = biz.getauthorized();
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cnt = biz.getcnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("trcnt", cnt);
		m.addAttribute("center", "trainers/trcenter");
		return "index";
	}
	
	@RequestMapping("/{pageNo}")
	public String findPage(@PathVariable("pageNo") int pageNo, Model m) {
		int amount = 5;
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
	
//	@RequestMapping("/{pageNo}")
//	public String findPage(@PathVariable(value = "pageNo") int pageNo, Model m) {
//		int pageSize = 6;
//		Page<TrainerVO> page = biz.findPage(pageNo, pageSize);
//		List<TrainerVO> list = page.getContent();
//		m.addAttribute("currentPage", pageNo);
//		m.addAttribute("totalPages", page.getTotalPages());
//		m.addAttribute("totalItems", page.getTotalElements());
//		m.addAttribute("trlist", list);
	
//		try {
//			List<TrainerVO> list = biz.getauthorized();
//			m.addAttribute("trlist", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			cnt = biz.getcnt();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		m.addAttribute("trcnt", cnt);
//		m.addAttribute("center", "trainers/trcenter");
//		return "index";
//	}
	
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
