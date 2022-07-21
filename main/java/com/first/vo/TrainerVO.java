package com.first.vo;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

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
	
	@Column(length = 300)
	private String intro;
	
	@Column(length = 300)
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
	private String addrshort;
	private MultipartFile lc1;
	private MultipartFile lc2;
	private MultipartFile lc3;
	private MultipartFile pf1;
	private MultipartFile pf2;
	private MultipartFile pf3;
	private int num;
	private int rownum;

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
			String gym_name, String gym_zip, String gym_addr1, String career) {
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
	}

	// for INSERT 2
	public TrainerVO(String id, String pwd, String name, String phone, String email, String gender, String major,
			String gym_name, String gym_zip, String gym_addr1, String gym_addr2, String intro, String career,
			String license1, String license2, String license3, String profile1, String profile2, String profile3) {
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
		this.gym_addr2 = gym_addr2;
		this.intro = intro;
		this.career = career;
		this.license1 = license1;
		this.license2 = license2;
		this.license3 = license3;
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.profile3 = profile3;
	}
	
	
	
	// 주소 두 번째 단어까지
	public void shortenaddr() {
		String[] addr = this.gym_addr1.split(" ");
		if(addr.length >= 2) {
			this.addrshort = addr[0].toString() + " " + addr[1].toString();
		}else {
			this.addrshort = addr[0].toString();
		}
	}
	
	// avgrate, rvcnt 세팅
	public void changeinfo(Double avgrate, int rvcnt) {
		this.avgrate = avgrate;
		this.rvcnt = rvcnt;
	}

	// 마이페이지 계정: 대표 프로필 사진 변경 
	public TrainerVO(String id, String profile1) {
		super();
		this.id = id;
		this.profile1 = profile1;
	}

	// 마이페이지 프로필: 프로필, 커리어 이미지 변경
	public TrainerVO(String id, String license1, String license2, String license3, String profile1, String profile2,
			String profile3) {
		super();
		this.id = id;
		this.license1 = license1;
		this.license2 = license2;
		this.license3 = license3;
//		this.profile1 = profile1;
		this.profile2 = profile2;
		this.profile3 = profile3;
	}

	// for UPDATE: status, status_detail 개별 수정
	public TrainerVO(String id, String status, String status_detail) {
		super();
		this.id = id;
		this.status = status;
		this.status_detail = status_detail;
	}
	
	
	
	
	
	

}
