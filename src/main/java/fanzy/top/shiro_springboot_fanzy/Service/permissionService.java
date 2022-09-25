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
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class permissionService {
	private permissionDao permissionDao = new permissionDaoImpl();

	public List<Permission> allPermissions_own(String name) {
		return permissionDao.allPermissions_own(name);
	}

}

