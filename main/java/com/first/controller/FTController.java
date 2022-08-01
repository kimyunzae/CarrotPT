package com.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.biz.TrainerBiz;
import com.first.biz.TrainerPreference;
import com.first.biz.TrainerSort;
import com.first.vo.MajorVO;
import com.first.vo.TrainerVO;

@Controller

@RequestMapping("/trainers")
public class FTController {

	@Autowired
	TrainerBiz biz;
	
	@Autowired
	TrainerSort trainersort;
	
	@Autowired
	TrainerPreference preference;
		
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
			cnt = list.toArray().length;
			
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
			cnt = list.toArray().length;
			
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
			m.addAttribute("dtrainer", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "trainers/trdetail");
		return "index";
	}
	
	@RequestMapping("/find")
	public void find(Model m, String trainerGender, String trainerMajor, String trainerWorkday, String trainerZip) {
		String[] trainerWorkdayArr= trainerWorkday.split(",");
		String[] trainerMajorArr = trainerMajor.split(",");
		try {
			List<TrainerVO> list = biz.getforpreference(trainerGender, trainerZip, trainerWorkdayArr, trainerMajorArr);
			trainersort.sortTrainer(list, "preference");
			for (TrainerVO trainerVO : list) {
				System.out.println(trainerVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
