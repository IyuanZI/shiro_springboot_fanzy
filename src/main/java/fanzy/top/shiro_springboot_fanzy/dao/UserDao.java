/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:09
 **/
package fanzy.top.shiro_springboot_fanzy.dao;


import fanzy.top.shiro_springboot_fanzy.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
	/**
	 * 通过名称查找用户
	 *
	 * @param name
	 * @return fanzy.top.shiro_springboot_fanzy.Entity.User
	 * @author fanzy
	 * @date 2022-09-30 14:50
	 */
	User queryUserByName(String name);

	/**
	 * 所有的用户信息（Admin）
	 *
	 * @return java.util.List<fanzy.top.shiro_springboot_fanzy.Entity.User>
	 * @author fanzy
	 * @date 2022-09-30 14:51
	 */
	List<User> queryAllUsers();

	/**
	 * 添加一个用户（注册）
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:51
	 */
	Integer addUser(User user);
}

