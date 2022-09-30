/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:23
 **/
package fanzy.top.shiro_springboot_fanzy.service;

import fanzy.top.shiro_springboot_fanzy.dao.Impl.permissionDaoImpl;
import fanzy.top.shiro_springboot_fanzy.dao.Impl.userDaoImpl;
import fanzy.top.shiro_springboot_fanzy.dao.permissionDao;
import fanzy.top.shiro_springboot_fanzy.dao.userDao;
import fanzy.top.shiro_springboot_fanzy.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class userService {
	private userDao userDao = new userDaoImpl();

	private permissionDao permissionDao = new permissionDaoImpl();

	public User queryUserByName(String name) {
		return userDao.queryUserByName(name);
	}

	public User addUser(User user) {
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setUpdateTime(new Date());

		switch (user.getRoleId()) {
			case 1:
				//	超级管理员
				return null;
			case 2:
				//	经理
				user.setRoleName("经理");
				if (userDao.addUser(user) == 1) {
					permissionDao.initManagerPerm(user);
					return queryUserByName(user.getUsername());
				} else {
					return null;
				}
			case 3:
				//	普通用户
				user.setRoleName("普通用户");
				if (userDao.addUser(user) == 1) {
					permissionDao.initUserPerm(user);
					return queryUserByName(user.getUsername());
				} else {
					return null;
				}
			default:
				return null;
		}
	}


	public List<User> queyruAllUsers() {
		return userDao.queryAllUsers();
	}

}
