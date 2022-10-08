package fanzy.top.shiro_springboot_fanzy.dao;

import fanzy.top.shiro_springboot_fanzy.entity.Permission;
import fanzy.top.shiro_springboot_fanzy.entity.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface PermissionDao {
	/**
	 * 查询个人权限
	 *
	 * @param name
	 * @return java.util.List<fanzy.top.shiro_springboot_fanzy.Entity.Permission>
	 * @author fanzy
	 * @date 2022-09-30 14:52
	 */
	List<Permission> allPermissions(String name);

	/**
	 * 添加一个权限
	 *
	 * @param permission
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:52
	 */
	Integer addPerm(Permission permission);

	/**
	 * 取消一个权限
	 *
	 * @param permission
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:53
	 */
	Integer movePerm(Permission permission);

	/**
	 * 初始化权限
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:53
	 */
	Integer initUserPerm(User user);

	/**
	 * 注册完成后的初始化权限，自动填入
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:53
	 */
	Integer initManagerPerm(User user);

}
