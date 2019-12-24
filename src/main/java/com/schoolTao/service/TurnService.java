package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.TurnMapper;
import com.schoolTao.pojo.Turn;
import com.schoolTao.pojo.Turn;
import com.schoolTao.pojo.TurnExample;

@Service
public class TurnService {

	@Autowired
	TurnMapper turnMapper;

	public int InsertTurn(Turn turn) {
		// TODO Auto-generated method stub
		int i = turnMapper.insertSelective(turn);//插入，可部分插入
		return i;
	}
	

	public List<Turn> SelectTurn() {
		
		
		List<Turn> turnlist = turnMapper.selectByExample(null);
		
		return turnlist;
	}


	public List<Turn> getTurn(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return turnMapper.selectByLimit(page,limit);
	}

	public Long countTurn() {
		// TODO Auto-generated method stub
		return turnMapper.countByExample(null);
	}

	public void deleteTurn(Integer turnId) {
		// TODO Auto-generated method stub
		turnMapper.deleteByPrimaryKey(turnId);
	}

	public void batchDelTurn(List<Integer> cidLst) {
		// TODO Auto-generated method stub
		for(int i=0; i<cidLst.size(); i++){
			turnMapper.deleteByPrimaryKey(cidLst.get(i));
		}
	}
	
	
	
}
