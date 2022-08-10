package com.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.biz.CslBiz;
import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@RestController
public class AJAXController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	@Autowired
	CslBiz cslbiz;

	@RequestMapping("checkid")
	public String checkid(String id) {
		String result = "";
		TraineeVO ie = null;

		if (id.equals("")) {
			return "1";
		}

		try {
			ie = traineebiz.get(id);
			if (ie == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping("checkemail")
	public String checkemail(String email) {
		String result = "";
		TraineeVO ie = null;

		if (email.equals("")) {
			return "1";
		}

		try {
			ie = traineebiz.get(email);
			if (ie == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 트레이니 마이페이지 : 비밀변호 변경
	@RequestMapping("techeckpwdchange")
	public String techeckpwdchange(String pwd, HttpSession session) {
		String result = "";

		try {
			TraineeVO trainee = (TraineeVO) session.getAttribute("logincust");
	
			if (trainee.getPwd().equals(pwd)) {
				result = "1";
			}

			else {
				result = "0";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

//	@RequestMapping("checkpwd")
//	public String checkpwd(String pwd) {
//		String result = "";
//		TraineeVO ie = null;
//		
//		if (pwd.equals("") || pwd == null) {
//			return "1";
//		}
//
//		try {
//			ie = traineebiz.get(pwd);
//			if(ie == null) {
//				result = "0";
//			}else {
//				result = "1";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}

//	회원가입 성공 시 joinok page 띄우기
//	@RequestMapping("/join_formimpl")
//	public String join_formimpl(Model m,String id, String pwd) {
//	System.out.println(id+""+pwd);
//	m.addAttribute("center","ajax/registerok");
//	m.addAttribute("left","ajax/left");
//		return "main";	
//	}

// ====================================== 트레이너 회원가입 ===========================================
	@RequestMapping("checktid")
	public String checktid(String id) {
		String result = "";
		TrainerVO i = null;

		if (id.equals("") || id == null) {
			return "1";
		}

		try {
			i = trainerbiz.get(id);
			if (i == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("checklogin")
	public String checklogin(String id, String pwd) {
		String result = "";
		TrainerVO tner = null;
		TraineeVO tnee = null;
		try {
			tner = trainerbiz.get(id);
			tnee = traineebiz.get(id);

			// 1) 아이디 존재하지 않음
			if (tner == null && tnee == null) {
				result = "none";
				// 2) trainer ID 존재
			} else if (tner != null && tnee == null) {
				if (tner.getPwd().equals(pwd)) {
					result = "success";
				} else {
					// trainer ID 비밀번호 불일치
					result = "fail";
				}
				// 3) trainee ID 존재
			} else if (tner == null && tnee != null) {
				if (tnee.getPwd().equals(pwd)) {
					result = "success";

				} else {
					// trainee ID 비밀번호 불일치
					result = "fail";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping("checktemail")
	public String checktemail(String email) {
		String result = "";
		TrainerVO i = null;

		if (email.equals("") || email == null) {
			return "1";
		}

		try {
			i = trainerbiz.getbyemail(email);
			if (i == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 트레이너 마이페이지: 비밀번호 변경
	@RequestMapping("checkpwdchange")
	public String checkpwdchange(String dpwd, HttpSession session) {
		String result = "";
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			if (trainer.getPwd().equals(dpwd)) {
				result = "1";
			}

			else {
				result = "0";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	// 트레이너 상세페이지: 매칭성사 체크
		@RequestMapping("checkreviewauthority")
		public String checkreviewauthority(String uid, String tid) {
			String result = "";
			String matching_status = "";
			try {
				matching_status = cslbiz.checkmatching(uid, tid);
				System.out.println("uid= " + uid + " | tid= " + tid);
				System.out.println(matching_status);
		
				if (matching_status != null && matching_status.equals("success")) {	
					result = "1";
				}
				else {
					result = "0";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(result);
			return result;
		}
	

}
