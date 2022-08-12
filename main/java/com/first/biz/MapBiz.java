package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.MapMapper;
import com.first.vo.MapVO;

@Service("mapbiz")
public class MapBiz implements Biz<Integer, MapVO> {
	
	@Autowired
	MapMapper dao;
	

	@Override
	public void register(MapVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(MapVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MapVO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapVO> get() throws Exception {
		return dao.selectall();
	}
	


}
