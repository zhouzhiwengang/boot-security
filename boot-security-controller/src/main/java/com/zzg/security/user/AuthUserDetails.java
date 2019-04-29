package com.zzg.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.zzg.entity.Permission;
import com.zzg.entity.Role;

public class AuthUserDetails implements UserDetails {
	
	
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	private String nickname;
    private String pswd;
    
    // 相关角色
    private List<Role> roles;
    // 相关权限
    private List<Permission> permission;
    
    // set 和  get 方法
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	
	// 构造函数
	public AuthUserDetails(String nickname, String pswd, List<Role> roles, List<Permission> permission) {
		super();
		this.nickname = nickname;
		this.pswd = pswd;
		this.roles = roles;
		this.permission = permission;
	}
	

	// 用户关联角色权限设置
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 List<GrantedAuthority> auths = new ArrayList<>();
		 List<Role> roles = this.getRoles();
		 for (Role role : roles) {
	            auths.add(new SimpleGrantedAuthority(role.getName()));
	        }
		 
		return auths;
	}

	// 用户密码设置
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pswd;
	}
	// 用户用户名设置
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nickname;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
