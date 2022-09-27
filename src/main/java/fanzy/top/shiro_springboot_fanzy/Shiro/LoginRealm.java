/**
 * @program: shiro_springboot_fanzy
 * @description: 自定义Realm类
 * @author: fanzy
 * @create: 2022-09-23 11:33
 **/
package fanzy.top.shiro_springboot_fanzy.Shiro;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.BeforeCompletion;
import java.security.Security;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(LoginRealm.class);

	@Autowired
	private permissionService permissionService;
	@Autowired
	private userService userService;

	/*
	 * 执行授权逻辑
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("执行授权逻辑");
		// 给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();

		User user = (User) subject.getPrincipal();

		List<Permission> perms = permissionService.allPermissions_own(user.getUsername());
		for (Permission perm : perms) {
			System.out.println(perm);
			if (perm.getPermissionPerms() != null && perm.getPermissionOwner()) {
				info.addStringPermission(perm.getPermissionPerms());
				// info.addStringPermission("perms[user:deleteFile]");
			}
		}
		return info;
	}

	/*
	 * 执行认证逻辑
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("执行认证逻辑");
		UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		User currentUser = userService.queryUserByName(token1.getUsername());

		if (currentUser == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(currentUser, currentUser.getPassword(), "");
	}
}

