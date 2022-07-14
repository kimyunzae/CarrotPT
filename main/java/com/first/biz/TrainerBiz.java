package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.ReviewMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.TrainerVO;

@Service("trainerbiz")
public class TrainerBiz implements Biz<String, TrainerVO>{
	
	@Autowired
	TrainerMapper dao;
	
	@Autowired
	ReviewMapper rdao;

	
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
	
	// 별점 평균, 리뷰 수, 주소 세팅
	public void trainerinfo(TrainerVO v) throws Exception {
		int cnt = rdao.selectcnt(v.getId());
		double avgrate = 0.0;
		v.setRvcnt(cnt);
		if(cnt == 0) {
			avgrate = 0.0;
		}else {
			avgrate = rdao.selectavg(v.getId());
		}
		v.setAvgrate(avgrate);
		v.shortenaddr();
	}
	
	@Override
	public TrainerVO get(String k) throws Exception {
		TrainerVO obj = dao.select(k);
		trainerinfo(obj);
		return obj;
	}

	@Override
	public List<TrainerVO> get() throws Exception {
		List<TrainerVO> list = dao.selectall();
		for (TrainerVO v : list) {
			trainerinfo(v);
		}
		return list;
	}

}
