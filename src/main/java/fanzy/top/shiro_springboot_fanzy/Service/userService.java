/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:23
 **/
package fanzy.top.shiro_springboot_fanzy.Service;

import fanzy.top.shiro_springboot_fanzy.Dao.Impl.userDaoImpl;
import fanzy.top.shiro_springboot_fanzy.Dao.userDao;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class userService {
	private userDao userDao = new userDaoImpl();

	public User queryUserByName(String name) {
		return userDao.queryUserByName(name);
	}

	public Integer addUser(User user) {
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setUpdateTime(new Date());
		return userDao.addUser(user);
	}


	public List<User> queyruAllUsers() {
		return userDao.queryAllUsers();
	}

}
