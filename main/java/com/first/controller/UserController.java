package com.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "user/login");
		return "index";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
		String result = "index";
		TrainerVO tner = null;
		TraineeVO tnee = null;
		try {
			tner = trainerbiz.get(id);
			tnee = traineebiz.get(id);
			
			// 1) 아이디 존재하지 않음
			if(tner == null && tnee == null) {
				result = "redirect:/login";
				// trainer ID 존재
			}else if(tner != null && tnee == null) {
				if(tner.getPwd().equals(pwd)) {
					m.addAttribute("logincust", tner);
					session.setAttribute("logincust", tner);
					result = "index";
				}else {
					// trainer ID 비밀번호 불일치
					result = "redirect:/login";
				}
				// 2) trainee ID 존재
			}else if(tner == null && tnee != null) {
				if(tnee.getPwd().equals(pwd)) {
					m.addAttribute("logincust", tnee);
					session.setAttribute("logincust", tnee);
					result = "index";
				}else {
					// 3) trainee ID 비밀번호 불일치
					result = "redirect:/login";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	@RequestMapping("/loginimpl")
//	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
//
//		TraineeVO trainee = null;
//		TrainerVO trainer = null;
//
//		try {
//			trainee = traineebiz.get(id);
//			if (trainee == null) {
//				trainer = trainerbiz.get(id);
//
//				if (trainer.getPwd().equals(pwd)) {
//					session.setAttribute("logintrainer", trainer);
//					m.addAttribute("logintrainer", trainer);
//				}
//			}
//			if (trainee.getPwd().equals(pwd)) {
//				session.setAttribute("logincust", trainee);
//				m.addAttribute("logincust", trainee);
//
//			} else {
//				return "redirect:/login";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "index";
//	}

	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "index";
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

//	@RequestMapping("join/trianeejoin")
//	public String traineejoin(Model m) {
//		m.addAttribute("center", "user/traineejoinselect");
//		return "index";
//	}
//	
	@RequestMapping("/mypage")
	public String mypage(Model m, String id) {
		try {
			TraineeVO vo = traineebiz.get(id);
			m.addAttribute("vo", vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "user/mypage");
		return "index";
	}

//
//	@PostMapping("/CheckMail") // AJAX와 URL을 매핑시켜줌 
//	@ResponseBody  //AJAX후 값을 리턴하기위해 작성
//
//		public String SendMail(String mail) {
//			Random random=new Random();  //난수 생성을 위한 랜덤 클래스
//			String key="";  //인증번호 
//
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setTo(mail); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
//			//입력 키를 위한 코드
//			for(int i =0; i<3;i++) {
//				int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
//				key+=(char)index;
//			}
//			int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
//			key+=numIndex;
//			message.setSubject("인증번호 입력을 위한 메일 전송");
//			message.setText("인증 번호 : "+key);
//			JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
//			javaMailSenderImpl.send(message);
//	        return key;
//		}	
//	
//	@RequestMapping("/tmypage")
//	public String tmypage(Model m) {
//		m.addAttribute("center", "user/tmypage");
//		return "index";
//	}

//	@PostMapping("/CheckMail") // AJAX와 URL을 매핑시켜줌 
//	@ResponseBody  //AJAX후 값을 리턴하기위해 작성
//
//		public String SendMail(String mail) {
//			Random random=new Random();  //난수 생성을 위한 랜덤 클래스
//			String key="";  //인증번호 
//
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setTo(mail); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
//			//입력 키를 위한 코드
//			for(int i =0; i<3;i++) {
//				int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
//				key+=(char)index;
//			}
//			int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
//			key+=numIndex;
//			message.setSubject("인증번호 입력을 위한 메일 전송");
//			message.setText("인증 번호 : "+key);
//			JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
//			javaMailSenderImpl.send(message);
//	        return key;
//		}	

	//트레이너 마이페이지: 메인
	@RequestMapping("/trmypage")
	public String trmypage(Model m, String id) {
		try {
			TrainerVO trainer = trainerbiz.get(id);
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "user/trmypage");
		m.addAttribute("trainercenter","user/trprofile");
		return "index";
	}
	
	//트레이너 마이페이지: 경력 및 수상
	@RequestMapping("/trcareer")
	public String trcareer(Model m, String id) {
		try {
			TrainerVO trainer = trainerbiz.get(id);
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "user/trmypage");
		m.addAttribute("trainercenter","user/trcareer");
		return "index";
	}
	
	//트레이너 마이페이지: 이용내역 
		@RequestMapping("/trhistory")
		public String trhistory(Model m) {
			m.addAttribute("center", "user/trmypage");
			m.addAttribute("trainercenter","user/trhistory");
			return "index";
		}

	
	// 관리자: 메인
	@RequestMapping("/admin")
	public String admin(Model m, String id) {
		try {
			List<TraineeVO> list = traineebiz.gettrainees();
			m.addAttribute("tneelist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "user/admin");
		m.addAttribute("admincenter", "user/admintrainee");
		return "index";
	}
	
	// 관리자: 일반회원 상세
	@RequestMapping("/admin/trainees")
	public String traineedetail(Model m, String id) {
		try {
			TraineeVO obj = traineebiz.get(id);
			m.addAttribute("vo", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "user/mypage");
		return "index";
	}

}
