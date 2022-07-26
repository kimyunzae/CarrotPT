package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.first.vo.MajorVO;
import com.first.vo.StatusVO;
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
	public int selectcnt(String status) throws Exception;
	public List<TrainerVO> selectbypage(@Param("pageNo")int pageNo, @Param("amount")int amount, @Param("orderBy")String orderBy, @Param("offset")int offset, @Param("status")String status) throws Exception;
	public List<TrainerVO> search(String loc, String major) throws Exception;
	public String selectbynamephone(String name, String phone) throws Exception;
	public String selectbyidemail(String id, String email) throws Exception;
	public String selectemailbyemail(String email) throws Exception;
	
	public List<MajorVO> selectmajor() throws Exception;
	public List<StatusVO> selectstatus() throws Exception;
	
	public void updatestatus(TrainerVO obj) throws Exception;
	
	public void updateProfile(TrainerVO obj) throws Exception;
	public void updateAccount(TrainerVO obj) throws Exception;
	
	public void updateProfile1(TrainerVO obj) throws Exception;
	public void updatepwd(TrainerVO obj) throws Exception;
}
