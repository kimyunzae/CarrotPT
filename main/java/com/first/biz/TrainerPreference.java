package com.first.biz;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.vo.TrainerVO;
import com.first.vo.WorkdayVO;

@Service
public class TrainerPreference {
	
	@Autowired
	WorkdayBiz workdaybiz; //biz가 biz를 상속하는 게 맞는지..? mapper 상속해야하는지

	public static final int genderScore = 1000;
	public static final int majorScore = 3000;
	public static final int workdayScore = 100;
	
	public void getPreference(TrainerVO trainer, String gender, String zip, String[] workdays, String[] majors) {
		if(trainer.getGender().equals(gender)) {
			trainer.addPreference(genderScore);
		}
		
		if(Arrays.asList(majors).contains(trainer.getMajor())) {
			trainer.addPreference(majorScore);
		}
		
		int custZip = Integer.parseInt(zip);
		int trainerZip = Integer.parseInt(trainer.getGym_zip());
		int absoluteZip = Math.abs(custZip - trainerZip);
		trainer.addPreference(100000 - (absoluteZip));
		
		for (String day : workdays) {
			try {
				WorkdayVO obj = workdaybiz.getbytidday(day, trainer.getId());
				if(obj != null) {
					trainer.addPreference(workdayScore);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
