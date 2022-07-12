package com.first.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TraineeVO {

	private String id; 
	private String pwd; 
	private String name; 
	private String phone; 
	private String email; 
	private String zip; 
	private String addr1; 
	private String addr2; 
	private Date regdate; 
	private String level;
	
	// for INSERT
	public TraineeVO(String id, String pwd, String name, String phone, String email, String zip, String addr1,
			String addr2) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.zip = zip;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}


	

}



