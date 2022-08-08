package com.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.CslBiz;
import com.first.biz.CslListBiz;
import com.first.biz.ReviewBiz;
import com.first.biz.TrainerBiz;
import com.first.biz.TrainerSort;
import com.first.biz.WorkdayBiz;
import com.first.vo.CslVO;
import com.first.vo.MajorVO;
import com.first.vo.ReviewVO;
import com.first.vo.TrainerVO;
import com.first.vo.WorkdayVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;
	
	@Autowired
	TrainerSort trainersort;
	
	@Autowired
	WorkdayBiz wbiz;
	
	@Autowired
	ReviewBiz rvbiz;
	
	@Autowired
	CslBiz cslbiz;
	
	@Autowired
	CslListBiz cslListbiz;
		
	@Value("6")
	private int amount;
	
	
	@ModelAttribute("amount")
	public int addAmount() {
		return amount;
	}
	
	@ModelAttribute("majors")
	public List<MajorVO> majors(){
		List<MajorVO> list = null;
		try {
			list = biz.getmajor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@RequestMapping("")
	public String main(Model m, Integer pageNo, String orderBy, String loc, String major) {
		
		if(pageNo == null) {
			pageNo = 1;
		}
		
		if(orderBy == null) {
			orderBy = "num";
		}
		
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		
		try {
			List<TrainerVO> list = biz.getauthorized(loc, major);
			trainersort.sortTrainer(list, orderBy);
			cnt = list.size();
			
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			
			list = list.subList(startIndex, endIndex);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trcenter");
		m.addAttribute("trcenter_info", "trainers/trcenter_info");
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("orderBy", orderBy);
		m.addAttribute("totalData", cnt);
		return "index";
	}
	
	
	@RequestMapping("/findpage")
	public String findPage(Model m, int pageNo, String orderBy, String loc, String major) {
		
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		
		try {
			List<TrainerVO> list = biz.getauthorized(loc, major);
			
			trainersort.sortTrainer(list, orderBy);
			cnt = list.size();
			
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			
			list = list.subList(startIndex, endIndex);
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("currentPage", pageNo);
		m.addAttribute("totalData", cnt);
		return "trainers/trcenter_info";
	}
	
	
	@RequestMapping("/detail")
	public String detail(Model m, String id) {
		try {
			TrainerVO obj = biz.get(id);
			List<ReviewVO> review = rvbiz.getbytid(id);
			WorkdayVO workday = wbiz.getbytid(id);
			m.addAttribute("dtrainer", obj);
//			session.setAttribute("dtrainer", obj);
			m.addAttribute("workday", workday);
			m.addAttribute("review", review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trdetail");
		return "index";
	}
	
	@RequestMapping("/find")
	public String find(Model m, String trainerGender, String trainerMajor, String trainerWorkday, String trainerZip) {
		String[] trainerWorkdayArr= trainerWorkday.split(",");
		String[] trainerMajorArr = trainerMajor.split(",");
		int cnt = 0;
		try {
			List<TrainerVO> list = biz.getforpreference(trainerGender, trainerZip, trainerWorkdayArr, trainerMajorArr);
			trainersort.sortTrainer(list, "preference");
			cnt = list.size();
			if(cnt >= amount) {
				list = list.subList(0, amount);
			}
			m.addAttribute("trlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "trainers/preference");
		m.addAttribute("gender", trainerGender);
		m.addAttribute("major", trainerMajor);
		m.addAttribute("workday", trainerWorkday);
		m.addAttribute("zip", trainerZip);
		return "index";
	}
	
	@RequestMapping("cslListaddimpl")
	public String cslListaddimpl(Model m, CslVO csl) {
		try {
			
			cslbiz.register(csl);
			
			System.out.println("csl: " +  cslbiz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
//	@RequestMapping("cslListaddimpl")
//	public String cslListaddimpl(Model m, CslListVO cslList, CslVO csl) {
//		try {
//			cslLbiz.register(cslList);
//			cslbiz.register(csl);
//			System.out.println("cslList: " +  cslLbiz);
//			System.out.println("csl: " +  cslbiz);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:/";
//	}
	

}
