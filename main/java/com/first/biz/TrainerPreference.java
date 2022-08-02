package com.first.biz;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.first.vo.TrainerVO;

@Service
public class TrainerPreference {

	public static final int genderScore = 1000;
	public static final int majorScore = 2000;
	public static final int workdayScore = 10;
	
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
				String result = trainer.getWorkday(day);
				if(result != null) {
					trainer.addPreference(workdayScore);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
