package com.zzg.service;

import java.util.List;

import com.zzg.entity.Role;

public interface RoleService {
	int deleteByPrimaryKey(Long id);
	 
    int insert(Role record);
 
    Role selectByPrimaryKey(Long id);
 
    List<Role> selectAll();
 
    int updateByPrimaryKey(Role record);
    
    List<Role> getByIds(List<Long> list);
}
