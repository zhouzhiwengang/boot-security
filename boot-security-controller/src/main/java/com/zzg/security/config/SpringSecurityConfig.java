package com.zzg.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import com.zzg.security.user.CustomerUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	UserDetailsService customUserService() {
		return new CustomerUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 设置密码为明文
		auth.userDetailsService(customUserService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//  允许所有用户访问"/"和"/index.html"
		         http.authorizeRequests()
		                 .antMatchers("/", "/index.html").permitAll()
		                 .anyRequest().authenticated()   // 其他地址的访问均需验证权限
		                 .and()
		                 .formLogin()
		                 .loginPage("/login.html")   //  登录页
		                 //.successForwardUrl("/index") // 登入成功后，跳转至指定页面
		                 .defaultSuccessUrl("/index")   // 访问指定页面，用户未登入，跳转至登入页面，如果登入成功，跳转至用户访问指定页面，用户访问登入页面，默认的跳转页面
		                 .failureUrl("/login-error.html").permitAll()
		                 .and()
		                 .logout()
		                 .logoutSuccessUrl("/index.html"); 
	}

}
