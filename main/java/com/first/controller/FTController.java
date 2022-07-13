package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		try {
			List<TrainerVO> list = biz.get();
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trcenter");
		return "index";
	}
	

}
