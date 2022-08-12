package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.MapVO;

@Repository
@Mapper
public interface MapMapper {
	public void insert(MapVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MapVO obj) throws Exception;
	public MapVO select(int id) throws Exception;
	public List<MapVO> selectall() throws Exception;
	
}
