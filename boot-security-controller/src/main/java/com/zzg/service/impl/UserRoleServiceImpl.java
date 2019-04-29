package com.zzg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.UserRole;
import com.zzg.mapper.UserRoleMapper;
import com.zzg.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper mapper;
	
	@Override
	public int insert(UserRole record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<UserRole> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public List<UserRole> getByUid(Long userId) {
		// TODO Auto-generated method stub
		return mapper.getByUid(userId);
	}

	@Override
	public List<UserRole> getByRid(Long roleId) {
		// TODO Auto-generated method stub
		return mapper.getByRid(roleId);
	}

}
