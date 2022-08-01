package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.ReviewMapper;
import com.first.vo.ReviewVO;

@Service("reviewbiz")
public class ReviewBiz implements Biz<Integer, ReviewVO> {

	@Autowired
	ReviewMapper dao;

	@Override
	public void register(ReviewVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ReviewVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ReviewVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReviewVO> get() throws Exception {
		return dao.selectall();
	}
	
	// tid별 리뷰 개수
	public int getcnt(String tid) throws Exception{
		return dao.selectcnt(tid);
	}
	
	public List<ReviewVO> getbytid(String tid) throws Exception {
		return dao.selectallbytid(tid);
	}
}
