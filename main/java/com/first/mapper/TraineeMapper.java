package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.first.vo.TraineeVO;

@Repository
@Mapper
public interface TraineeMapper {
	public void insert(TraineeVO v) throws Exception;
	public void delete(String k) throws Exception;
	public void update(TraineeVO v) throws Exception;
	public TraineeVO select(String k) throws Exception;
	public List<TraineeVO> selectall() throws Exception;
	
	public TraineeVO selectbyemail(String k);
	public String selectbynamephone(String name, String phone) throws Exception;
	public String selectbyidemail(String id, String email) throws Exception;
	public String selectemailbyemail(String email) throws Exception;

	public List<TraineeVO> selecttrainees() throws Exception;
	public int selectcnt() throws Exception;
	public List<TraineeVO> selectbypage(@Param("pageNo")Integer pageNo, @Param("amount")int amount, @Param("orderBy")String orderBy, @Param("offset")int offset) throws Exception;
	
	public void updatepwd(TraineeVO v) throws Exception;
	
	public void updatepassword(TraineeVO v) throws Exception;
}
