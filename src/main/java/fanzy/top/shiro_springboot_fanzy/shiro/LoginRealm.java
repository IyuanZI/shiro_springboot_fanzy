package fanzy.top.shiro_springboot_fanzy.shiro;

import fanzy.top.shiro_springboot_fanzy.entity.Permission;
import fanzy.top.shiro_springboot_fanzy.entity.User;
import fanzy.top.shiro_springboot_fanzy.service.PermissionService;
import fanzy.top.shiro_springboot_fanzy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: shiro_springboot_fanzy
 * @description: 自定义Realm类
 * @author: fanzy
 * @create: 2022-09-23 11:33
 **/
public class LoginRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(LoginRealm.class);

	@Resource
	private PermissionService permissionService;
	@Resource
	private UserService userService;

	/**
	 * 执行授权逻辑
	 *
	 * @param principals
	 * @return org.apache.shiro.authz.AuthorizationInfo
	 * @author fanzy
	 * @date 2022-10-08 8:52
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("执行授权逻辑");
		// 给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();

		User user = (User) subject.getPrincipal();

		List<Permission> perms = permissionService.allPermissions(user.getUsername());
		for (Permission perm : perms) {
			// System.out.println(perm);
			if (perm.getPermissionPerms() != null && perm.getPermissionOwner()) {
				info.addStringPermission(perm.getPermissionPerms());
			}
		}
		return info;
	}

	/**
	 * 执行认证逻辑
	 *
	 * @param token
	 * @return org.apache.shiro.authc.AuthenticationInfo
	 * @author fanzy
	 * @date 2022-10-08 8:52
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("执行认证逻辑");
		// 登录的Token，包含用户名和密码
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		String tokenName = passwordToken.getUsername();
		ByteSource salt = ByteSource.Util.bytes(tokenName);
		User user = userService.queryUserByName(passwordToken.getUsername());

		if (passwordToken == null) {
			return null;
		}
		/*
		 * 认证过程：
		 * 	shiro将手动加密的数据库中的密码，和用户输入的密码（shiro进行加密的）进行比对
		 * */
		return new SimpleAuthenticationInfo(user, user.getPassword(), salt, "");
	}
}

