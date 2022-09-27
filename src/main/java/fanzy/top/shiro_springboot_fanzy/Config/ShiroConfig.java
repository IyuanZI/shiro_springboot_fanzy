package fanzy.top.shiro_springboot_fanzy.Config;

import fanzy.top.shiro_springboot_fanzy.Controller.userController;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Shiro.LoginRealm;
import org.apache.shiro.SecurityUtils;
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
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
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
		//
		linkedHashMap.put("/admin/addUser", "perms[admin_addUser]");
		linkedHashMap.put("/admin/moveUser", "perms[admin_moveUser]");
		linkedHashMap.put("/admin/modifyUser", "perms[admin_modifyUser]");
		linkedHashMap.put("/admin/allUsers", "perms[admin_allUsers]");
		linkedHashMap.put("/admin/addPerm", "perms[admin_addPerm]");

		linkedHashMap.put("/user/currentUser", "perms[user_currentUser]");
		linkedHashMap.put("/user/scanPerms", "perms[user_scanPerms]");
		linkedHashMap.put("/user/addFile", "perms[user_addFile]");
		linkedHashMap.put("/user/deleteFile", "perms[user_deleteFile]");


		linkedHashMap.put("/user/**", "authc");
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
	public LoginRealm getRealm() {
		return new LoginRealm();
	}
}
