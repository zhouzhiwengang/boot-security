package com.zzg.mapper;

import com.zzg.entity.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();
    
    List<UserRole> getByUid(Long userId);
    List<UserRole> getByRid(Long roleId);
}