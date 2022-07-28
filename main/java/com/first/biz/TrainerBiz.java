package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.ReviewMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.MajorVO;
import com.first.vo.StatusVO;
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
		if(obj != null) {
			trainerinfo(obj);
		}
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
	public List<TrainerVO> getauthorized(String loc, String major) throws Exception{
		List<TrainerVO> list = dao.selectauthorized(loc, major);
		for (TrainerVO v : list) {
			trainerinfo(v);
		}
		return list;
	}
	
	// status별 trainer 데이터 개수
	public int getcnt(String status) throws Exception{
		return dao.selectcnt(status);
	}
	
	// 페이지, 정렬
	public List<TrainerVO> getbypage(int pageNo, int amount, String orderBy, int offset, String status) throws Exception{
		
		int offset2 = (pageNo - 1) * amount;
		List<TrainerVO> list = dao.selectbypage(pageNo, amount, orderBy, offset2, status);

		for (TrainerVO v : list) {
			trainerinfo(v);
		}
		return list;
	}
	
	// 등록된 운동 종류 선택
	public List<MajorVO> getmajor() throws Exception{
		List<MajorVO> list = dao.selectmajor();
		return list;
	};
	
	// 등록된 status 선택
	public List<StatusVO> getstatus() throws Exception{
		List<StatusVO> list = dao.selectstatus();
		return list;
	}
	
	// 개별 status UPDATE
	public void modifystatus(TrainerVO v) throws Exception{
		dao.updatestatus(v);
	}


	public void modifyProfile(TrainerVO v) throws Exception {
		dao.updateProfile(v);
	}
	

	public void modifyAccount(TrainerVO v) throws Exception {
		dao.updateAccount(v);
	}
	
	public void modifyPassword(TrainerVO v) throws Exception {
		dao.updatePassword(v);
	}
	
	// 이름, phone으로 선택
	public String getbynamephone(String name, String phone) throws Exception{
		return dao.selectbynamephone(name, phone);
	}


	
	

}
