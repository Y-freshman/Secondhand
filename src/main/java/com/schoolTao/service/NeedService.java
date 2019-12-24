package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.NeedMapper;
import com.schoolTao.pojo.Need;
import com.schoolTao.pojo.Need;
import com.schoolTao.pojo.NeedExample;

@Service
public class NeedService {

	@Autowired
	NeedMapper needMapper;

	public int InsertNeed(Need need) {
		// TODO Auto-generated method stub
		int i = needMapper.insertSelective(need);//插入，可部分插入
		return i;
	}
	
	public void UpdateNeed(int needId) {
		
		needMapper.addNum(needId);
	}
	
	public List<Need> SelectNeed(int i) {
		
		List<Need> needlist;
		if(i == 0){
			needlist = needMapper.selectNeedAndUser(null);
		}else{
			needlist = needMapper.selectNeedAndUser2(null);
		}
		return needlist;
	}

	public List<Need> getNeed(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return needMapper.selectByLimit(page,limit);
	}

	public Long countNeed() {
		// TODO Auto-generated method stub
		return needMapper.countByExample(null);
	}

	public void deleteNeed(Integer needId) {
		// TODO Auto-generated method stub
		needMapper.deleteByPrimaryKey(needId);
	}

	public void batchDelNeed(List<Integer> cidLst) {
		// TODO Auto-generated method stub
		for(int i=0; i<cidLst.size(); i++){
			needMapper.deleteByPrimaryKey(cidLst.get(i));
		}
	}
	
	public List<Need> userSelectNeed(Integer i,Integer userId) {
		List<Need> needlist;
		if(i == 0 || i == null){
			needlist = needMapper.selectUserNeed(userId);
		}else{
			needlist = needMapper.selectUserNeedHot(userId);
		}
		
		return needlist;
	}

}
