package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.TraineeMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Service("traineebiz")
public class TraineeBiz implements Biz<String, TraineeVO> {

	@Autowired
	TraineeMapper dao;
	
	@Autowired
	TrainerMapper trainerdao;

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
	
	// level이 '일반회원'인 수
	public int getcnt() throws Exception{
		int cnt = dao.selectcnt();
		return cnt;
	}
	
	// 페이지, 정렬
	public List<TraineeVO> getbypage(Integer pageNo, int amount, String orderBy, int offset) throws Exception{
		if(orderBy == null) {
			orderBy = "regdate desc";
		}
		if(pageNo == null) {
			pageNo = 1;
		}
		int offset2 = (pageNo - 1) * amount;
		List<TraineeVO> list = dao.selectbypage(pageNo, amount, orderBy, offset2);

		return list;
	}
	
	// 이름, phone으로 선택
	public String getbynamephone(String name, String phone) throws Exception{
		return dao.selectbynamephone(name, phone);
	}
	
	// trainee, trainer 통합 아이디찾기
	public String findid(String name, String phone) throws Exception{
		String id = dao.selectbynamephone(name, phone);
		if(id == null) {
			id = trainerdao.selectbynamephone(name, phone);
		}
		if(id == null) {
			id = "0";
		}
		return id;
	}
	
	// trainee, trainer 통합 비밀번호찾기
	public String findpwd(String id, String email) throws Exception{
		String result = dao.selectbyidemail(id, email);
		if(result == null) {
			result = trainerdao.selectbyidemail(id, email);
		}
		if(result == null) {
			result = "0";
		}
		return result;
	}
	
	// trainee, trainer 통합 비밀번호 업데이트
	public void updatepwd(String email, String pwd) throws Exception{
		String trainer = null;
		String trainee = null;
		
		trainer = trainerdao.selectemailbyemail(email);
		trainee = dao.selectemailbyemail(email);
		
		if(trainer != null && trainee == null) {
			TrainerVO newTrainer = new TrainerVO(pwd, email);
			trainerdao.updatepwd(newTrainer);
			
		}else if(trainer == null && trainee != null) {
			TraineeVO newTrainee = new TraineeVO(pwd, email);
			dao.updatepwd(newTrainee);
		}
	}

}
