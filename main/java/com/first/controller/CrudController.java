package com.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.frame.Util;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class CrudController {

	@Autowired
	TrainerBiz trainerbiz;

	@Autowired
	TraineeBiz traineebiz;
	
	@Value("${admindir}")
	String admindir;

	@RequestMapping("tregisterimpl")
	public String tregisterimpl(Model m, TrainerVO t) {
		String profile1 = t.getPf1().getOriginalFilename();
		String profile2 = t.getPf2().getOriginalFilename();
		String profile3 = t.getPf3().getOriginalFilename();
		String license1 = t.getLc1().getOriginalFilename();
		String license2 = t.getLc2().getOriginalFilename();
		String license3 = t.getLc3().getOriginalFilename();
		
		t.setProfile1(profile1); 
		t.setProfile2(profile2);
		t.setProfile3(profile3);
		t.setLicense1(license1);
		t.setLicense2(license2);
		t.setLicense3(license3);

		try {
			trainerbiz.register(t);
			Util.saveFile(t.getPf1(),t.getPf2(),t.getPf3(),
					t.getLc1(),t.getLc2(),t.getLc3(),admindir);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/joinimpl")
	public String joinimpl(Model m, TraineeVO trainee, HttpSession session) {
		try {
			traineebiz.register(trainee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
