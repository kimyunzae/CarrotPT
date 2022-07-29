package com.first.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.vo.TrainerVO;
import com.first.vo.WorkdayVO;

@Service
public class TrainerPreference {
	
	@Autowired
	WorkdayBiz workdaybiz;

	public static final int genderScore = 1000;
	public static final int zipScore = 1;
	public static final int workdayScore = 100;
	
	public void getPreference(TrainerVO trainer, String gender, String zip, String[] workdays) {
		if(trainer.getGender().equals(gender)) {
			trainer.addPreference(genderScore);
		}
		
		int custZip = Integer.parseInt(zip);
		int trainerZip = Integer.parseInt(trainer.getGym_zip());
		int absoluteZip = Math.abs(custZip - trainerZip);
		trainer.addPreference(100000 - (absoluteZip * zipScore));
		
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
