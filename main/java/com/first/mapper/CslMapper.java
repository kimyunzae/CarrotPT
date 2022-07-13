package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.CslVO;

@Repository
@Mapper
public interface CslMapper {
	public void insert(CslVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CslVO obj) throws Exception;
	public void updateread(CslVO obj) throws Exception;
	public void updateprogress(CslVO obj) throws Exception;	
	public CslVO select(int id) throws Exception;
	public List<CslVO> selectall() throws Exception;
}
