package com.first.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewVO {
	private int id;
	private String uid;
	private String tid;
	private int rv_rate;
	private String rv_text;
	private Date rv_regdate;
	
	// for INSERT
	public ReviewVO(String uid, String tid, int rv_rate, String rv_text) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.rv_rate = rv_rate;
		this.rv_text = rv_text;
	}

	// for UPDATE
	public ReviewVO(int id, int rv_rate, String rv_text) {
		super();
		this.id = id;
		this.rv_rate = rv_rate;
		this.rv_text = rv_text;
	}

	
	
	
	
	
}
