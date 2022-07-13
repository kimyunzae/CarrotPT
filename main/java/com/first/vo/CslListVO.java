package com.first.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CslListVO {
	private int id;
	private String uid;
	private String age;
	private String gender;
	private String purpose;
	private String frequency;
	
	// for INSERT
	public CslListVO(String uid, String age, String gender, String purpose, String frequency) {
		this.uid = uid;
		this.age = age;
		this.gender = gender;
		this.purpose = purpose;
		this.frequency = frequency;
	}

	public CslListVO(int id, String age, String gender, String purpose, String frequency) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.purpose = purpose;
		this.frequency = frequency;
	}
	
	
}
