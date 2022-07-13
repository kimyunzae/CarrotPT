package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.ReportMapper;
import com.first.vo.ReportVO;

@Service("reportbiz")
public class ReportBiz implements Biz<Integer, ReportVO> {
	
	@Autowired
	ReportMapper dao;

	@Override
	public void register(ReportVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ReportVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ReportVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReportVO> get() throws Exception {
		return dao.selectall();
	}

	
	
}