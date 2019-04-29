package com.zzg.security.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zzg.entity.Permission;
import com.zzg.entity.Role;
import com.zzg.entity.RolePermission;
import com.zzg.entity.User;
import com.zzg.entity.UserRole;
import com.zzg.service.PermissionService;
import com.zzg.service.RolePermissionService;
import com.zzg.service.RoleService;
import com.zzg.service.UserRoleService;
import com.zzg.service.UserService;

public class CustomerUserService implements UserDetailsService {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RolePermissionService rolePermissionService;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.getByUserName(username);
		if (user == null) {
	            throw new UsernameNotFoundException("用户名不存在");
	    }
		// 用户涉及角色
		List<UserRole> userRoles = userRoleService.getByUid(user.getId());
		List<Long> list = userRoles.stream().map(UserRole::getRid).collect(Collectors.toList());
		List<Role> roles = roleService.getByIds(list);
		
 
		// 用户涉及权限
		List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
		List<RolePermission> rolePermissions = rolePermissionService.getByRoleIds(roleIds);
 
		List<Long> permissionIds = rolePermissions.stream().map(RolePermission::getPid).collect(Collectors.toList());
		List<Permission> permissions = permissionService.getByPermissionIds(permissionIds);

		//返回用户详情数据信息
		AuthUserDetails authUserDetails = new AuthUserDetails(user.getNickname(),user.getPswd(),roles,permissions);
		return authUserDetails;
	}

}
