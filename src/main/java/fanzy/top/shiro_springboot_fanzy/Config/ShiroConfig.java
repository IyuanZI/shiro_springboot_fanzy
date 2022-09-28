package fanzy.top.shiro_springboot_fanzy.Config;

import fanzy.top.shiro_springboot_fanzy.Controller.userController;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Shiro.LoginRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.Customizer;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
	private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	/*
	 * 创建ShiroFilterFactoryBean
	 * */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(manager);
		// shiroFilterFactoryBean.setLoginUrl("/login");
		// shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
		/*
		 * 内置过滤器：
		 * 	anon:无需认证
		 * 	authc:必须认证才可以访问
		 * 	user:如果使用 RememberMe 的功能可以直接访问
		 * 	perms:该资源必须得到角色权限才可以访问
		 *  所有资源需要登录才可以访问
		 *	同理：只要登录了，都可以访问
		 *	linkedHashMap.put("/api/user/**","authc");
		 * */

		linkedHashMap.put("/login/**", "anon");
		linkedHashMap.put("/regist/**", "anon");

		//
		linkedHashMap.put("/admin/addUser", "perms[admin:addUser]");
		linkedHashMap.put("/admin/moveUser", "perms[admin:moveUser]");
		linkedHashMap.put("/admin/modifyUser", "perms[admin:modifyUser]");
		linkedHashMap.put("/admin/allUsers", "perms[admin:allUsers]");
		linkedHashMap.put("/admin/addPerm", "perms[admin:addPerm]");

		linkedHashMap.put("/user/currentUser", "perms[user:currentUser]");

		linkedHashMap.put("/user/scanPerms", "perms[user:scanPerms]");
		linkedHashMap.put("/user/movePerm", "perms[user:movePerm]");

		linkedHashMap.put("/user/addFile", "perms[user:addFile]");
		linkedHashMap.put("/user/deleteFile", "perms[user:deleteFile]");


		linkedHashMap.put("/**", "authc");
		for (String s : linkedHashMap.values()
		) {
			System.out.println(s);
		}
		shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
		return shiroFilterFactoryBean;
	}

	/*
	 * sessionManager
	 * */
	@Bean(name = "sessionManager")
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
		defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
		return defaultWebSessionManager;
	}


	/*
	 * 创建manager
	 * */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityMannager(@Qualifier("LoginRealm") LoginRealm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSessionManager(sessionManager());
		securityManager.setRealm(realm);
		return securityManager;
	}

	/*
	 * 创建Realm
	 * */
	@Bean(name = "LoginRealm")
	public LoginRealm getRealm(@Qualifier("credentialsMatcher") HashedCredentialsMatcher matcher) {
		LoginRealm loginRealm = new LoginRealm();
		loginRealm.setCredentialsMatcher(matcher);
		return loginRealm;
	}

	/**
	 * 替换当前 Realm 的 credentialsMatcher 属性.
	 * 直接使用 HashedCredentialsMatcher 对象, 并设置加密算法即可.
	 * 密码校验规则HashedCredentialsMatcher
	 * 这个类是为了对密码进行编码的
	 * 防止密码在数据库中明码表示,当然在登录认证的时候,
	 * 这个类也负责对form里输入的密码进行编码
	 * 处理认证匹配处理器
	 */
	@Bean("credentialsMatcher")
	public HashedCredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		//设置加密算法
		matcher.setHashAlgorithmName("MD5");
		//设置加密次数
		matcher.setHashIterations(3);
		//是否存储为16进制
		//将setStoredCredentialsHexEncoded设置为true，则需要使用toHex()进行转换成字符串，默认使用的是toBase64()
		matcher.setStoredCredentialsHexEncoded(true);
		return matcher;
	}
}
