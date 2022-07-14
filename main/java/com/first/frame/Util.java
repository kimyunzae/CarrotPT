package com.first.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile pf1, MultipartFile pf2, 
			MultipartFile pf3, MultipartFile lc1, MultipartFile lc2,
			MultipartFile lc3, String admindir) {
	
		byte [] data;
		String profile1 = pf1.getOriginalFilename();
		String profile2 = pf2.getOriginalFilename();
		String profile3 = pf3.getOriginalFilename();
		String lisence1 = lc1.getOriginalFilename();
		String lisence2 = lc2.getOriginalFilename();
		String lisence3 = lc3.getOriginalFilename();
		
		try {
			data = pf1.getBytes();
			data = pf2.getBytes();
			data = pf3.getBytes();
			data = lc1.getBytes();
			data = lc2.getBytes();
			data = lc3.getBytes();
			
			FileOutputStream fo1 = new FileOutputStream(admindir+profile1);
			FileOutputStream fo2 = new FileOutputStream(admindir+profile2);
			FileOutputStream fo3 = new FileOutputStream(admindir+profile3);
			FileOutputStream fo4 = new FileOutputStream(admindir+lisence1);
			FileOutputStream fo5 = new FileOutputStream(admindir+lisence2);
			FileOutputStream fo6 = new FileOutputStream(admindir+lisence3);
			
			fo1.write(data);
			fo2.write(data);
			fo3.write(data);
			fo4.write(data);
			fo5.write(data);
			fo6.write(data);
			
			fo1.close();
			fo2.close();
			fo3.close();
			fo4.close();
			fo5.close();
			fo6.close();
		
		}catch(Exception e) {
			
		}
		
	}
	
}

