package fanzy.top.shiro_springboot_fanzy.Config;

import fanzy.top.shiro_springboot_fanzy.Controller.userController;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Shiro.LoginRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
	private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	@Autowired
	private permissionService permissionService;

	/*
	 * 创建ShiroFilterFactoryBean
	 * */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(manager);
		shiroFilterFactoryBean.setLoginUrl("/api/login");
		/*
		 * 内置过滤器：
		 * 	anon:无需认证
		 * 	authc:必须认证才可以访问
		 * 	user:如果使用 RememberMe 的功能可以直接访问
		 * 	perms:该资源必须得到角色权限才可以访问
		 *
		 *	linkedHashMap.put("/api/user/**","authc");
		 * */
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

		linkedHashMap.put("/**","authc");
		linkedHashMap.put("/api/login","anon");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
		return shiroFilterFactoryBean;
	}

	/*
	 * 创建manager
	 * */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityMannager(@Qualifier("LoginRealm") LoginRealm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
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
