package com.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class CrudController {

	@Autowired
	TrainerBiz trainerbiz;

	@Autowired
	TraineeBiz traineebiz;

	@RequestMapping("/addimpl")
	public String addimpl(Model m, TrainerVO t) {
//		String imgname = t.getMf().getOriginalFilename();
//		t.setPimgname(imgname);

		try {
			trainerbiz.register(t);
//			Util.saveFile(t.getMf(), admindir);
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
