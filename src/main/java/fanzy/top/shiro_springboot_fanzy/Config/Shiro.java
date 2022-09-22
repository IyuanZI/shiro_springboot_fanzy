/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 13:40
 **/
package fanzy.top.shiro_springboot_fanzy.Config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Shiro {
	public static void main(String[] args) {
		//1.
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");

		//2.
		SecurityManager securityManager = factory.getInstance();

		//3.
		SecurityUtils.setSecurityManager(securityManager);

		System.exit(0);
	}
}

