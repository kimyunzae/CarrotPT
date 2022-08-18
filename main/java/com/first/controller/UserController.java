package com.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.biz.MailBiz;
import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class UserController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	@Autowired
	MailBiz mailbiz;
	
//	@RequestMapping("/login")
//	public String login(Model m, String msg) {
//		m.addAttribute("center", "user/login");
//		m.addAttribute("msg", msg);
//		return "redirect:/";
//	}

	@ResponseBody
	@PostMapping(value = "/loginimpl")
	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
		String result = "";
		
		TrainerVO tner = null;
		TraineeVO tnee = null;
		try {
			tner = trainerbiz.get(id);
			tnee = traineebiz.get(id);
			
			// 1) trainer ID 존재
			if(tner != null && tnee == null) {
				if(tner.getPwd().equals(pwd)) {
					result = "1";
					
					session.setAttribute("custLevel", tner.getLevel());
					session.setAttribute("custid", id);
					m.addAttribute("logincust", tner);
					session.setAttribute("logincust", tner);
				}else {
					// trainer ID 비밀번호 불일치
					result = "0";
				}
				// 2) trainee ID 존재
			}else if(tner == null && tnee != null) {
				if(tnee.getPwd().equals(pwd)) {
					result = "1";
					session.setAttribute("custLevel", tnee.getLevel());
					session.setAttribute("custid", id);
					m.addAttribute("logincust", tnee);
					session.setAttribute("logincust", tnee);
				}else {
					// trainee ID 비밀번호 불일치
					result = "0";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}
	
	@RequestMapping("/update")
	public String update(Model m,TraineeVO obj) {
		
		try {
			traineebiz.modify(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}//"redirect:detail?id=" +obj.getId();
		
		return "redirect:detail?id="+obj.getId();
	}

	@RequestMapping("/join")
	public String join(Model m) {
		m.addAttribute("center", "user/join");
		return "index";
	}

	@RequestMapping("/join/trainer")
	public String trainerjoin(Model m) {
		m.addAttribute("center", "user/trainerjoin");
		return "index";
	}

	@RequestMapping("/join/trainee")
	public String traineejoinselect(Model m) {
		m.addAttribute("center", "user/traineejoin");
		return "index";
	}
	
	//소셜로그인테스트용
	@RequestMapping("/join/trainee2")
	public String traineejoin2(Model m) {
		m.addAttribute("center", "user/traineejoin2");
		return "index";
	}
	
	@RequestMapping("/findidpwd")
	public String findidpwd(Model m) {
		m.addAttribute("center", "user/findidpwd");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/findidimpl")
	public String findidimpl(String name, String phone) {
		String id = null;
		try {
			id = traineebiz.findid(name, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	@ResponseBody
	@RequestMapping("/findpwdimpl")
	public String findpwdimpl(String id, String email) {
		String recipient = null;
		try {
			recipient = traineebiz.findpwd(id, email);
			if(recipient != "0") {
				String newpwd = mailbiz.randompwd();
				mailbiz.sendmail(recipient, newpwd);
				traineebiz.updatepwd(email, newpwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipient;
	}
	
	@RequestMapping("/userlogin")
	public String userlogin(Model m) {
		m.addAttribute("center", "user/login");
		return "index";
	}
	@RequestMapping("/backhome")
	public String backhome(Model m) {
		m.addAttribute("center");
		return "index";
	}
	
	@ResponseBody
	@PostMapping(value = "/nlogin")
	public String nloginid(Model m, String nloginid, HttpSession session) {
		String result = "";
		String nlogin = null;
		try {
			nlogin = traineebiz.selectn(nloginid);			
			if(nlogin != null) {
				if(nlogin.equals("nlogin")) {
					result = "1";
					TraineeVO tnee = traineebiz.get(nloginid);
					session.setAttribute("custLevel", tnee.getLevel());
					session.setAttribute("custid", nloginid);
					m.addAttribute("logincust", tnee);
					session.setAttribute("logincust", tnee);
				}else {
					// trainee ID 비밀번호 불일치
					result = "실패";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
		
	}
}
