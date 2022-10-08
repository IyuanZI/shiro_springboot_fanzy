
package fanzy.top.shiro_springboot_fanzy.service;

import fanzy.top.shiro_springboot_fanzy.dao.Impl.PermissionDaoImpl;
import fanzy.top.shiro_springboot_fanzy.entity.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-24 10:49
 **/
@Service
public class PermissionService {
	@Resource
	private PermissionDaoImpl permissionDao;
	@Resource
	private UserService userService;

	public List<Permission> allPermissions(String name) {
		if (permissionDao.allPermissions(name).size() != 0) {
			return permissionDao.allPermissions(name);
		}
		return null;
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

