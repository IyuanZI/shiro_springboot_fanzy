/**
 * @program: shiro_springboot_fanzy
 * @description: 自定义Realm类
 * @author: fanzy
 * @create: 2022-09-23 11:33
 **/
package fanzy.top.shiro_springboot_fanzy.Shiro;

import fanzy.top.shiro_springboot_fanzy.Service.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(LoginRealm.class);
	@Autowired
	private userService userService;

	/*
	 * 执行授权逻辑
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("执行授权逻辑");
		return null;
	}

	/*
	 * 执行认证逻辑
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("执行认证逻辑");
		UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		if (userService.queryUserByName(token1.getUsername()) == null) {
			return null;
		}
		return new SimpleAuthenticationInfo("", userService.queryUserByName(token1.getUsername()).getPassword(), "");
	}
}

