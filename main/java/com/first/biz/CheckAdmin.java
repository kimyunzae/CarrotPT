package com.first.biz;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class CheckAdmin {
	
	public boolean checkadmin(HttpSession session) {
		Object level = session.getAttribute("custLevel");
		if(level == null || !(level.toString().equals("관리자"))) {
			return false;
		}else {
			return true;
		}
	}
}
