package com.zzg.mapper;

import com.zzg.entity.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    List<RolePermission> selectAll();
    
    List<RolePermission> getByRoleIds(List<Long> rids);
}