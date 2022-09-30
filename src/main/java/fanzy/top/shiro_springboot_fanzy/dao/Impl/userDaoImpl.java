/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 12:01
 **/
package fanzy.top.shiro_springboot_fanzy.dao.Impl;

import fanzy.top.shiro_springboot_fanzy.config.mybatis;
import fanzy.top.shiro_springboot_fanzy.dao.userDao;
import fanzy.top.shiro_springboot_fanzy.entity.User;

import java.util.List;

public class userDaoImpl implements userDao {
	/**
	 * 通过名称查找用户
	 *
	 * @param name
	 * @return fanzy.top.shiro_springboot_fanzy.Entity.User
	 * @author fanzy
	 * @date 2022-09-30 14:50
	 */
	@Override
	public User queryUserByName(String name) {
		User user = (User) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectOne("userMapper.queryUserByName", name);
		});
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	/**
	 * 所有的用户信息（Admin）
	 *
	 * @return java.util.List<fanzy.top.shiro_springboot_fanzy.Entity.User>
	 * @author fanzy
	 * @date 2022-09-30 14:51
	 */
	@Override
	public List<User> queryAllUsers() {
		List<User> users = (List<User>) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectList("userMapper.queryAllUser");
		});
		return users;
	}
	
	/**
	 * 添加一个用户（注册）
	 *
	 * @param user
	 * @return java.lang.Integer
	 * @author fanzy
	 * @date 2022-09-30 14:51
	 */
	@Override
	public Integer addUser(User user) {
		return (Integer) mybatis.executeUpdate(sqlSession -> {
			return sqlSession.insert("userMapper.addUser", user);
		});
	}
}

