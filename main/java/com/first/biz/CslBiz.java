package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.CslMapper;
import com.first.mapper.ReportMapper;

import com.first.vo.CslVO;

@Service("cslbiz")
public class CslBiz implements Biz<Integer, CslVO> {
	
	@Autowired
	CslMapper dao;

	@Override
	public void register(CslVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CslVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public CslVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CslVO> get() throws Exception {
		return dao.selectall();
	}

	// 수락 여부 수정
	public void modifyread(CslVO v) throws Exception {
		dao.updateread(v);
	}
	
	// 상담 완료 여부 수정
	public void modifyprogress(CslVO v) throws Exception{
		dao.updateprogress(v);
	}



	
	
}
