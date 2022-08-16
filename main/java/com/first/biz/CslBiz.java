package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.CslMapper;
import com.first.mapper.TraineeMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.CslNumVO;
import com.first.vo.CslVO;

@Service("cslbiz")
public class CslBiz implements Biz<Integer, CslVO> {
	
	@Autowired
	CslMapper dao;
	
	@Autowired
	TrainerMapper trainerdao;
	
	@Autowired
	TraineeMapper traineedao;

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
	public void modifymatch(CslVO v) throws Exception{
		dao.updatematch(v);
	}
	
	public List<CslVO> getbyuid(String uid) throws Exception{
		return dao.selectbyuid(uid);
	}
	
	public List<CslVO> getbytid(String tid) throws Exception{
		return dao.selectbytid(tid);
	}

	public List<CslVO> getlistbyid(String id) throws Exception{
		String trainer = trainerdao.selectbyid(id);
		List<CslVO> list = null;
		if(trainer != null) {
			list = dao.selectbytid(id);
		}else {
			list = dao.selectbyuid(id);
		}
		return list;
	}
	
	public CslNumVO getnumbyid(String id) throws Exception{
		String trainer = trainerdao.selectbyid(id);
		CslNumVO obj = new CslNumVO();
		if(trainer != null) {
			obj = dao.selectnumbytid(id);
		}else {
			obj = dao.selectnumbyuid(id);
		}
		return obj;
	}
	
	public String checkmatching(String uid, String tid) throws Exception {
		return dao.checkmatching(uid, tid);
	}

	
	
}
