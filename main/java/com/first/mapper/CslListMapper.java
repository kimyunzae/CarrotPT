package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.CslListVO;

@Repository
@Mapper
public interface CslListMapper {
	public void insert(CslListVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CslListVO obj) throws Exception;	
	public CslListVO select(int id) throws Exception;
	public List<CslListVO> selectall() throws Exception;
	public List<CslListVO> selectbyuid(String uid) throws Exception;
}
