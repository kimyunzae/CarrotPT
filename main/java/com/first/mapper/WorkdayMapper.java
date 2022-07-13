package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.ReportVO;
import com.first.vo.WorkdayVO;

@Repository
@Mapper
public interface WorkdayMapper {
	public void insert(WorkdayVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(WorkdayVO obj) throws Exception;	
	public WorkdayVO select(int id) throws Exception;
	public List<WorkdayVO> selectall() throws Exception;
}
