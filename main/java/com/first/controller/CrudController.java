package com.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@Controller
public class CrudController {

	@Autowired
	TrainerBiz biz;
	
	@RequestMapping("/addimpl")
	public String addimpl(Model m, TrainerVO t) {
//		String imgname = t.getMf().getOriginalFilename();
//		t.setPimgname(imgname);

		try {
			biz.register(t);
//			Util.saveFile(t.getMf(), admindir);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}
	
}
