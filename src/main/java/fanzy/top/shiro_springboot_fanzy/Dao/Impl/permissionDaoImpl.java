/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-23 14:36
 **/
package fanzy.top.shiro_springboot_fanzy.Dao.Impl;

import fanzy.top.shiro_springboot_fanzy.Dao.permissionDao;
import fanzy.top.shiro_springboot_fanzy.Entity.Permission;

public class permissionDaoImpl implements permissionDao {
	@Override
	public Permission allPermissions() {
		return null;
	}

	@Override
	public Permission allPermissions_own(int id) {
		return null;
	}

	@Override
	public Permission allPermissions_ano(int id) {
		return null;
	}

	@Override
	public void givePermissionsTo_own(int id) {

	}

	@Override
	public void givePermissionsTo_ano(int id) {

	}

	@Override
	public void movePermissionFrom_own(int id) {

	}

	@Override
	public void movePermissionFrom_ano(int id) {

	}
}

