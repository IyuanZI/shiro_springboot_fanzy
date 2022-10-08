
package fanzy.top.shiro_springboot_fanzy.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-28 15:56
 **/
public class RegRealm extends AuthorizingRealm {
	/**
	 * 授权
	 *
	 * @param principals
	 * @return org.apache.shiro.authz.AuthorizationInfo
	 * @author fanzy
	 * @date 2022-10-08 9:27
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证
	 *
	 * @param token
	 * @return org.apache.shiro.authc.AuthenticationInfo
	 * @author fanzy
	 * @date 2022-10-08 9:27
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return null;
	}
}

