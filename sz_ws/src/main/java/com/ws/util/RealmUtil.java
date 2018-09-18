package com.ws.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.ws.model.Users;
import com.ws.service.DutyService;
import com.ws.service.RoleService;
import com.ws.service.UsersService;

/**
 * @author lujun
 * @date 2018年7月11日
 */
public class RealmUtil extends AuthorizingRealm {
	
	@Resource
	private UsersService usersService;
	@Resource
	private RoleService roleService;
	@Resource
	private DutyService permissionService;
	
	public String getName() {
		return "RealmUtil";
	}
	//授权操作
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Users users=(Users) principals.getPrimaryPrincipal();
		List<String> permissions=new ArrayList<String>();
		List<String> roles=new ArrayList<>();
		if("admin".equals(users.getUserCode())){
			//拥有所有权限
			permissions.add("*:*");
			//拥有所有角色
			roles=roleService.selectAllRole();
		}else{
			//更具用户编码查询该用户的角色
			roles=roleService.selectByUserCodeRole(users.getStoreCode());
			//根据用户编码查询用户的权限
			permissions=permissionService.selectByUserCodePermission(users.getUserCode());
		}
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		info.addRoles(roles);
		return info;
	}

	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userCode=(String) token.getPrincipal();
		Users users=usersService.queryByUserCode(userCode);
		if(users==null){
			return null;
		}
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(users,users.getUserPsw(),ByteSource.Util.bytes(users.getUserCode()),getName());
		return info;
	}

}
