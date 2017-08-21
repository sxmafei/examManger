package com.mf.realm;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.mf.domain.Employee_in;
import com.mf.mapper.UserMapper;
import com.mf.service.UserService;
import com.mf.util.MyAuthorizingRealm;


public class MyRealm extends MyAuthorizingRealm {

	@Resource
	private UserService userService;
	
	@Resource
	private UserMapper userMapper;
	/**
	 * 为当前登陆成功的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String name=((Employee_in) principals.getPrimaryPrincipal()).getName();		
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		Set<String> roles=userService.addRoleByName(name);
		Set<String> permissions=userService.getPermissionByName(name);
		if (roles!=null) {
			simpleAuthorizationInfo.setRoles(roles);
		}
		if (permissions!=null) {
			simpleAuthorizationInfo.setStringPermissions(permissions);
		}			
		return simpleAuthorizationInfo;
	}

	
	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName=(String) token.getPrincipal();
		Employee_in employee_in=userService.getEmployee_inByName(userName);
		if (employee_in!=null) {
			AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(employee_in, employee_in.getPassword(),"xx");			
			return authenticationInfo;
		} else {
			return null;
		}
	}
	
	//清除缓存
	public void clearCache(){
		PrincipalCollection principalCollection=SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principalCollection);
	}

}
