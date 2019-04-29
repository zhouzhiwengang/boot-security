package com.zzg.service;

import java.util.List;

import com.zzg.entity.Permission;

public interface PermissionService {
	int deleteByPrimaryKey(Long id);
	 
	int insert(Permission record);
 
	Permission selectByPrimaryKey(Long id);
 
	List<Permission> selectAll();
 
	int updateByPrimaryKey(Permission record);
	
	List<Permission> getByPermissionIds(List<Long> ids);
}
