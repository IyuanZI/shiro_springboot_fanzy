/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-24 10:49
 **/
package fanzy.top.shiro_springboot_fanzy.Service;

import fanzy.top.shiro_springboot_fanzy.Dao.Impl.permissionDaoImpl;
import fanzy.top.shiro_springboot_fanzy.Dao.permissionDao;
import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class permissionService {
	private permissionDao permissionDao = new permissionDaoImpl();
	@Resource
	private userService userService;

	public List<Permission> allPermissions(String name) {
		return permissionDao.allPermissions(name);
	}

	public Integer addPerm(Permission permission) {
		permission.setCreateTime(userService.queryUserByName(permission.getUsername()).getCreateTime());
		permission.setLastLoginTime(userService.queryUserByName(permission.getUsername()).getCreateTime());
		permission.setUpdateTime(new Date());
		return permissionDao.addPerm(permission);
	}

	public Permission findPermission(String username, String permId) {
		List<Permission> permissions = allPermissions(username);
		for (Permission perms : permissions
		) {
			if (perms.getPermissionId().equals(permId)) {
				return perms;
			}
		}
		return null;
	}


	public Integer movePerm(String username, String permId) {
		return permissionDao.movePerm(findPermission(username, permId));
	}
}

