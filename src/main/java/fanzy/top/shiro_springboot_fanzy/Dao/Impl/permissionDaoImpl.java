/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-23 14:36
 **/
package fanzy.top.shiro_springboot_fanzy.Dao.Impl;

import fanzy.top.shiro_springboot_fanzy.Config.mybatis;
import fanzy.top.shiro_springboot_fanzy.Dao.permissionDao;
import fanzy.top.shiro_springboot_fanzy.Entity.Permission;

import java.util.List;

public class permissionDaoImpl implements permissionDao {

	@Override
	public List<Permission> allPermissions_own(String name) {
		return (List<Permission>) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectList("permissionMapper.allPermissions", name);
		});
	}

	@Override
	public Integer addPerm(Permission permission) {
		return (Integer) mybatis.executeUpdate(sqlSession -> {
			return sqlSession.insert("permissionMapper.addPermission", permission);
		});
	}
}

