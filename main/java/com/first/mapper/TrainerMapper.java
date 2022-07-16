package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.vo.TrainerVO;

@Mapper
@Repository
public interface TrainerMapper{
	public void insert(TrainerVO obj) throws Exception;
	public void delete(String obj) throws Exception;
	public void update(TrainerVO obj) throws Exception;
	public TrainerVO select(String obj) throws Exception;
	public List<TrainerVO> selectall() throws Exception;
	public TrainerVO selectbyemail(String obj) throws Exception;
	public List<TrainerVO> selectauthorized() throws Exception;
	public int selectcnt() throws Exception;
}
