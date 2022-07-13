package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.CslListMapper;
import com.first.vo.CslListVO;

@Service("csllistbiz")
public class CslListBiz implements Biz<Integer, CslListVO> {
	
	@Autowired
	CslListMapper dao;

	@Override
	public void register(CslListVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CslListVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public CslListVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CslListVO> get() throws Exception {
		return dao.selectall();
	}
	
	// uid로 선택
	public List<CslListVO> getbyuid(String uid) throws Exception{
		return dao.selectbyuid(uid);
	}

}
