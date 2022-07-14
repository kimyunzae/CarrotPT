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

public class TrainerVO {

	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private String major;
	private String gym_name;
	private String gym_zip;
	private String gym_addr1;
	private String gym_addr2;
	private String intro;
	private String career;
	private String license1;
	private String license2;
	private String license3;
	private String status;
	private String status_detail;
	private String profile1;
	private String profile2;
	private String profile3;
	private String regdate;
	private String level;
	private Double avgrate;
	private int rvcnt;

	
	// for update 트레이너 name,regdate 제외 모두 수정 가능

	public TrainerVO(String id, String pwd, String phone, String email, String gender, String major, String gym_name,
			String gym_zip, String gym_addr1, String gym_addr2, String intro, String career, String license1,
			String license2, String license3, String status, String status_detail, String profile1, String profile2,
			String profile3, String level) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.major = major;
		this.gym_name = gym_name;
		this.gym_zip = gym_zip;
		this.gym_addr1 = gym_addr1;
		this.gym_addr2 = gym_addr2;
		this.intro = intro;
		this.career = career;
		this.license1 = license1;
		this.license2 = license2;
		this.license3 = license3;
		this.status = status;
		this.status_detail = status_detail;
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.profile3 = profile3;
		this.level = level;
	}
	
	// for insert default null과 default 값 존재하는 column 제외

	public TrainerVO(String id, String pwd, String name, String phone, String email, String gender, String major,
			String gym_name, String gym_zip, String gym_addr1, String career, String regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.major = major;
		this.gym_name = gym_name;
		this.gym_zip = gym_zip;
		this.gym_addr1 = gym_addr1;
		this.career = career;
		this.regdate = regdate;
	}
	


}
