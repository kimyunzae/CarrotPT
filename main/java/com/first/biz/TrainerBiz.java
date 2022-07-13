package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.TrainerMapper;
import com.first.vo.TrainerVO;

@Service("trainerbiz")
public class TrainerBiz implements Biz<String, TrainerVO>{
	
	@Autowired
	TrainerMapper dao;
	
	@Override
	public void register(TrainerVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(TrainerVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public TrainerVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<TrainerVO> get() throws Exception {
		return dao.selectall();
	}

}
