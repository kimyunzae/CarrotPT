package com.first.vo;

import java.util.Date;

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
public class cslVO {
	private int id;
	private String uid;
	private String tid;
	private String csl_workday;
	private Date csl_date;
	private String csl_time;
	private String csl_read;
	private String csl_progress;
	
	public  cslVO(String uid,String tid,String csl_workday,
			Date csl_date,String csl_time,String csl_read,String csl_progress) {
		this.uid=uid;
		this.tid=tid;
		this.csl_workday=csl_workday;
		this.csl_date= csl_date;
		
	}
}
