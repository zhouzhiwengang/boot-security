package com.zzg.mapper;

import com.zzg.entity.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
    
    List<Permission> getByPermissionIds(List<Long> ids);
}