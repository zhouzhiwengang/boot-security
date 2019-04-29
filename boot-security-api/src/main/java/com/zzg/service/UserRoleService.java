package com.zzg.service;

import java.util.List;

import com.zzg.entity.UserRole;

public interface UserRoleService {
	int insert(UserRole record);
	 
    List<UserRole> selectAll();
    
    List<UserRole> getByUid(Long userId);
    
    List<UserRole> getByRid(Long roleId);
}
