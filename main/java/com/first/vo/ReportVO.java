package com.first.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
public class ReportVO {
	private int id;
	private String uid;
	private String tid;
	private String rp_reason;
	private String rp_detail;
	private String rp_imgname;
	private MultipartFile mf;
	private String rp_status;
	private Date rp_regdate;
	
	
	// for INSERT
	public ReportVO(String uid, String tid, String rp_reason, String rp_detail, String rp_imgname, MultipartFile mf) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.rp_reason = rp_reason;
		this.rp_detail = rp_detail;
		this.rp_imgname = rp_imgname;
		this.mf = mf;
	}
	
	// for UPDATE
	public ReportVO(int id, String rp_status) {
		super();
		this.id = id;
		this.rp_status = rp_status;
	}


	
}
