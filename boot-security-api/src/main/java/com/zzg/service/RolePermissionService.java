package com.zzg.service;

import java.util.List;

import com.zzg.entity.RolePermission;

public interface RolePermissionService {
	int insert(RolePermission record);
	 
	List<RolePermission> selectAll();
	
	List<RolePermission> getByRoleIds(List<Long> rids);

}
