/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-23 14:36
 **/
package fanzy.top.shiro_springboot_fanzy.dao.Impl;

import fanzy.top.shiro_springboot_fanzy.config.MybatisConfig;
import fanzy.top.shiro_springboot_fanzy.dao.PermissionDao;
import fanzy.top.shiro_springboot_fanzy.entity.Permission;
import fanzy.top.shiro_springboot_fanzy.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PermissionDaoImpl implements PermissionDao {
	/**
	 * 权限列表
	 *
	 * @param name
	 * @return java.util.List<fanzy.top.shiro_springboot_fanzy.Entity.Permission>
	 * @author fanzy
	 * @date 2022-09-30 15:01
	 */
	@Override
	public List<Permission> allPermissions(String name) {
		return (List<Permission>) MybatisConfig.excuteQuery(sqlSession -> {
			return sqlSession.selectList("permissionMapper.allPermissions", name);
		});
	}

	/**
	 * 增加一个权限
	 *
	 * @param permission
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 15:01
	 */
	@Override
	public Integer addPerm(Permission permission) {
		return (Integer) MybatisConfig.executeUpdate(sqlSession -> {
			return sqlSession.insert("permissionMapper.addPermission", permission);
		});
	}

	/**
	 * 移除一个权限
	 *
	 * @param permission
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 15:01
	 */
	@Override
	public Integer movePerm(Permission permission) {
		return (Integer) MybatisConfig.executeUpdate(sqlSession -> {
			return sqlSession.update("permissionMapper.updatePermission", permission);
		});
	}

	/**
	 * 普通用户的初始化权限
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 15:02
	 */
	@Override
	public Integer initUserPerm(User user) {
		return (Integer) MybatisConfig.executeUpdate(sqlSession -> {
			return sqlSession.insert("permissionMapper.initUserPerm", user);
		});
	}

	/**
	 * 经理的初始化权限
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 15:02
	 */
	@Override
	public Integer initManagerPerm(User user) {
		return (Integer) MybatisConfig.executeUpdate(sqlSession -> {
			return sqlSession.insert("permissionMapper.initManagerPerm", user);
		});
	}
}

