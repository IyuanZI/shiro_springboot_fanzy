package fanzy.top.shiro_springboot_fanzy.Dao;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;

public interface permissionDao {
	// 查询权限列表
	Permission allPermissions();

	// 查询个人权限
	Permission allPermissions_own(int id);

	// 查询指定用户的权限列表
	Permission allPermissions_ano(int id);

	// 给当前用户某一个权限
	void givePermissionsTo_own(int id);

	// 给指定用户某一个权限
	void givePermissionsTo_ano(int id);

	// 删除当前用户某一个权限
	void movePermissionFrom_own(int id);

	// 删除指定用户某一个权限
	void movePermissionFrom_ano(int id);

}
