package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.WorkdayMapper;
import com.first.vo.WorkdayVO;

@Service("workdaybiz")
public class WorkdayBiz implements Biz<Integer, WorkdayVO> {
	
	@Autowired
	WorkdayMapper dao;

	@Override
	public void register(WorkdayVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override 
	public void modify(WorkdayVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public WorkdayVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<WorkdayVO> get() throws Exception {
		return dao.selectall();
	}

	public WorkdayVO getbytid(String tid) throws Exception {
		return dao.selectbytid(tid);
	}

	
	
}
