package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.TraineeMapper;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Service("traineebiz")
public class TraineeBiz implements Biz<String, TraineeVO> {

	@Autowired
	TraineeMapper dao;

	@Override
	public void register(TraineeVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(TraineeVO v) throws Exception {
		dao.update(v);

	}

	@Override
	public TraineeVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<TraineeVO> get() throws Exception {
		return dao.selectall();
	}

	
	// 이메일로 선택
	public TraineeVO getbyemail(String k) {
		TraineeVO obj = dao.selectbyemail(k);
		return obj;
	}
	
	// level이 '일반회원'인 목록
	public List<TraineeVO> gettrainees() throws Exception{
		List<TraineeVO> list = dao.selecttrainees();
		return list;
	}
	
	// 페이지, 정렬
	public List<TraineeVO> getbypage(int pageNo, int amount, String orderBy, int offset) throws Exception{
		if(orderBy == null) {
			orderBy = "regdate desc";
		}
		int offset2 = (pageNo - 1) * amount;
		List<TraineeVO> list = dao.selectbypage(pageNo, amount, orderBy, offset2);

		return list;
	}

}
