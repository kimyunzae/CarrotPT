package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@Controller
public class MainController {
	
	@Autowired
	TrainerBiz trainerbiz;

	@Value("${dir1}")
	String dir1;

	
	@RequestMapping("/")
	public String main(Model m) {
		List<TrainerVO> trainerlist = null;
		try {
			trainerlist = trainerbiz.get();
			
			m.addAttribute("trainerlist", trainerlist);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		m.addAttribute("center", "center");
		return "index";
	}
}
