package com.first.controller; 


import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TraineeBiz;
import com.first.vo.TraineeVO;

@Controller
public class UserController {
	
	@Autowired
	TraineeBiz traineebiz;
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "user/login");
		return "index";
	}

@RequestMapping("/loginimpl")
public String loginimpl(Model m, String id, String pwd, HttpSession session) {
    try {
        TraineeVO obj = traineebiz.get(id);
        
        if(obj.getPwd().equals(pwd)) {
            session.setAttribute("logincust", obj);
            m.addAttribute("logincust", obj);
            
        }else {
            return "redirect:/login";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "index";
}
	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
	if(session != null) {
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
	public String mypage(Model m) {
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
	
	
	
	@RequestMapping("/tmypage")
	public String tmypage(Model m) {
		m.addAttribute("center", "user/tmypage");
		return "index";
	}

}
