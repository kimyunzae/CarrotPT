package com.first.biz;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.frame.Biz;
import com.first.mapper.ReviewMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.TraineeVO;
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
		if(cnt == 0) {
			avgrate = 0.0;
		}else {
			avgrate = rdao.selectavg(v.getId());
		}
		v.changeinfo(avgrate, cnt);
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
	
	// email로 선택
	public TrainerVO getbyemail(String k) throws Exception {
		TrainerVO obj = dao.selectbyemail(k);
		trainerinfo(obj);
		return obj;
	}
	
	// status가 '수락'인 trainer 목록
	public List<TrainerVO> getauthorized() throws Exception{
		List<TrainerVO> list = dao.selectauthorized();
		for (TrainerVO v : list) {
			trainerinfo(v);
		}
		return list;
	}
	
	// status가 '수락'인 trainer 데이터 개수
	public int getcnt() throws Exception{
		return dao.selectcnt();
	}
	
//	public Page<TrainerVO> findPage(int pageNo, int pageSize){
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//		return dao.findAll(pageable);
//	}


	

}
