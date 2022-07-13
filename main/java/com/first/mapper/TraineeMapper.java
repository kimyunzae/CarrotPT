package com.first.mapper;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
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
	
}
