package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.MapMapper;
import com.first.vo.MapVO;

@Service("mapbiz")
public abstract class MapBiz implements Biz<Integer, MapVO> {
	
	@Autowired
	MapMapper dao;
	
	@Autowired
	MapMapper mapdao;
	
	public List<MapVO> getList(MapVO searchVO) {
	    return dao.getList(searchVO);
	}
	/*
	 * public List<MapVO> getList(MapVO searchVO) { return selectList("getList",
	 * searchVO); }
	 */

}
