package com.first.frame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.first.vo.TrainerVO;

@Service
public class TrainerSort {
	
	public void sortTrainer(List<TrainerVO> list, String orderby) {

		Collections.sort(list, new Comparator<TrainerVO>() {

			@Override
			public int compare(TrainerVO o1, TrainerVO o2) {
				int result = 1;
				switch(orderby) {
				case "num":
					if(o1.getNum() >= o2.getNum()) {
						result = -1;
					}
					break;
					
				case "rvcnt":
					if(o1.getRvcnt() >= o2.getRvcnt()) {
						result = -1;
					}
					break;
					
				case "id": 
					if(o1.getId().charAt(0) > o2.getId().charAt(0)) {
						result = -1;
					}else if(o1.getId().charAt(0) == o2.getId().charAt(0)) {
						result = o1.getId().compareTo(o2.getId());
					}else {
						result = -1;
					}
					break;
					
				case "name": 
					StringBuilder stringBuilder1 = new StringBuilder();
					StringBuilder stringBuilder2 = new StringBuilder();
					for (char c : o1.getName().toCharArray()) {
						korfirst(stringBuilder1, c);
					}
					for (char c : o2.getName().toCharArray()) {
						korfirst(stringBuilder2, c);
					}
					result = stringBuilder1.toString().compareTo(stringBuilder2.toString());
					break;
					
//				case "regdate":
//					if(o1.getRegdate().charAt(0) > o2.getRegdate().charAt(0)) {
//						result = -1;
//					}else if(o1.getRegdate().charAt(0) == o2.getRegdate().charAt(0)) {
//						result = o1.getRegdate().compareTo(o2.getRegdate());
//					}else {
//						result = -1;
//					}
//					break;
				}
				
				return result;
			}
		});
	}
	
	public void korfirst(StringBuilder stringBuilder, char c) {
		if(Pattern.matches("[가-힣]", new StringBuilder(c))) {
			stringBuilder.append((char)(c-44030));
		}else {
			stringBuilder.append((char)(c+44032));
		}
	}
}
