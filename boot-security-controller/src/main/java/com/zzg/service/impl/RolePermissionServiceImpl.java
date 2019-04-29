package com.zzg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.RolePermission;
import com.zzg.mapper.RolePermissionMapper;
import com.zzg.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionMapper mapper;

	@Override
	public int insert(RolePermission record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<RolePermission> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public List<RolePermission> getByRoleIds(List<Long> rids) {
		// TODO Auto-generated method stub
		return mapper.getByRoleIds(rids);
	}

}
