package fanzy.top.shiro_springboot_fanzy.Shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
	/*
	 * 创建ShiroFilterFactoryBean
	 * */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(manager);
		/*
		* 内置过滤器：
		* 	anon:无需认证
		* 	authc:必须认证才可以访问
		* 	user:如果使用 RememberMe 的功能可以直接访问
		* 	perms:该资源必须得到角色权限才可以访问
		* */
		// LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		// linkedHashMap.put("/api/user/**","authc");
		// shiroFilterFactoryBean.setLoginUrl("/login");
		// shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);

		return shiroFilterFactoryBean;
	}

	/*
	 * 创建manageer
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
