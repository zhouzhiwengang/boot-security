package com.zzg.service;

import java.util.List;

import com.zzg.entity.User;

public interface UserService {
	int deleteByPrimaryKey(Long id);
	 
	int insert(User record);
 
	User selectByPrimaryKey(Long id);
 
	List<User> selectAll();
 
	int updateByPrimaryKey(User record);
	
	User getByUserName(String username);
}
