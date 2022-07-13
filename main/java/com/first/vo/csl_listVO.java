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
public class Csl_listVO {
	private String id;
	private String uid;
	private String age;
	private String purpose;
	private String frequency;
	public  Csl_listVO(String uid,String age,String purpose,String frequency) {
		this.uid=uid;
		this.age=age;
		this.purpose=purpose;
		this.frequency=frequency;
	}
}
