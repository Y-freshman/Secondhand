package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.GoodsMapper;
import com.schoolTao.dao.UserMapper;
import com.schoolTao.pojo.Goods;
import com.schoolTao.pojo.GoodsExample;
import com.schoolTao.pojo.Need;
import com.schoolTao.pojo.User;
import com.schoolTao.pojo.UserExample;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User loginUser(String root){
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(root);
		User user = new User();
		if(userMapper.selectByExample(userExample).size() == 0){
			System.out.println(userMapper.selectByExample(userExample).size());
			user = null;
		}else{
			user = userMapper.selectByExample(userExample).get(0);
		}
		return user;
	}
	
	public void registerUser(User user){
		userMapper.insertSelective(user);
	}
	
	public String resetUser(User user){
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(user.getUserName()).andUserMibaoEqualTo(user.getUserMibao()).andUserAnswerEqualTo(user.getUserAnswer());
		String code;
		if(userMapper.selectByExample(userExample).size() == 0){
			code = "500";
		}else{
			userMapper.updateByExampleSelective(user,userExample);
			code = "200";
		}
		return code;
	}

	/**
	 * 获取所有用户
	 * @param limit 
	 * @param page 
	 * @return
	 */
	public List<User> getUser(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return userMapper.selectByLimit(page,limit);
	}

	/**
	 * 删除某个用户
	 * @param userId
	 */
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(userId);
	}

	/**
	 * 批量删除用户
	 * @param uidLst
	 */
	public void batchDelUser(List<Integer> uidLst) {
		// TODO Auto-generated method stub
		for(int i=0; i<uidLst.size(); i++){
			userMapper.deleteByPrimaryKey(uidLst.get(i));
		}
	}

	public User users(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}


	public void selfUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	public Long countUser() {
		// TODO Auto-generated method stub
		return userMapper.countByExample(null);
	}
	
}
