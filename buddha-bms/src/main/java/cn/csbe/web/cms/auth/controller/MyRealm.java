package cn.csbe.web.cms.auth.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.auth.bean.UserRoleMenu;
import cn.csbe.web.cms.auth.service.IAuthService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private IAuthService authService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		// 根据用户名查找权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String userName = collection.getPrimaryPrincipal().toString();
		List<UserRoleMenu> permissonList = authService.getUserPermissionByUserName(userName);
		
		if(permissonList != null && permissonList.size() > 0){
			Set<String> roles = new HashSet<String>();
			Set<String> permissions = new HashSet<String>();
			for(UserRoleMenu menu : permissonList){
				roles.add(menu.getRoleId()+"");
				permissions.add(menu.getUrl());
			}
			
			authorizationInfo.setRoles(roles);
			authorizationInfo.setStringPermissions(permissions);
			
			return authorizationInfo;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UserPassword user = authService.getUserPasswordByUserName(token.getPrincipal().toString());
		if(user != null){
			String password = user.getPwd();
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getPhone(), password,"myRealm");
			return authenticationInfo;
		}
		return null;
	}

}
