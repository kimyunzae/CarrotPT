package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.ReviewVO;

@Repository
@Mapper
public interface ReviewMapper {
	public void insert(ReviewVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ReviewVO obj) throws Exception;	
	public ReviewVO select(int id) throws Exception;
	public List<ReviewVO> selectall() throws Exception;
	public int selectcnt(String tid) throws Exception;
	public double selectavg(String tid) throws Exception;
}
