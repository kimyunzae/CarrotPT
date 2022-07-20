package com.first.mapper;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Repository
@Mapper
public interface TraineeMapper {
	public void insert(TraineeVO v) throws Exception;
	public void delete(String k) throws Exception;
	public void update(TraineeVO v) throws Exception;
	public TraineeVO select(String k) throws Exception;
	public List<TraineeVO> selectall() throws Exception;
	public TraineeVO selectbyemail(String k);
	public List<TraineeVO> selecttrainees() throws Exception;
	public List<TraineeVO> selectbypage(@Param("pageNo")int pageNo, @Param("amount")int amount, @Param("orderBy")String orderBy, @Param("offset")int offset) throws Exception;
}
