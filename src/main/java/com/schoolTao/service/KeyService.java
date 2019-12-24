package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.KeyMapper;
import com.schoolTao.pojo.Key;
import com.schoolTao.pojo.Remain;

@Service
public class KeyService {
	@Autowired
	KeyMapper keyMapper;
	
	public void insertKey(Key key){
		keyMapper.insertSelective(key);
	}

	public List<Key> getkeys(Integer page, Integer limit) {
		return keyMapper.getKeys(page,limit);
	}

	public Long countKey() {
		return keyMapper.countByExample(null);
	}

	public void deletekey(Integer keyId) {
		keyMapper.deleteByPrimaryKey(keyId);
	}

	public void deleteKeys(List<Integer> list) {
		for(int i=0; i<list.size(); i++){
			keyMapper.deleteByPrimaryKey(list.get(i));
		}
	}
}
