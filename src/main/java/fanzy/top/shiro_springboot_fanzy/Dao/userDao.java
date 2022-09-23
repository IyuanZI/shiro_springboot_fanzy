/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:09
 **/
package fanzy.top.shiro_springboot_fanzy.Dao;


import fanzy.top.shiro_springboot_fanzy.Entity.User;

import java.util.List;


public interface userDao {
	User queryUserByName(String name);

	List<User> queryAllUsers();
}

