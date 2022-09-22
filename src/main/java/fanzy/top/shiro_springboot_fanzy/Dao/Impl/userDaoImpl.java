/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 12:01
 **/
package fanzy.top.shiro_springboot_fanzy.Dao.Impl;

import fanzy.top.shiro_springboot_fanzy.Config.mybatis;
import fanzy.top.shiro_springboot_fanzy.Dao.userDao;
import fanzy.top.shiro_springboot_fanzy.Entity.User;

import java.util.List;

public class userDaoImpl implements userDao {
	@Override
	public User queryUserByName(String name) {
		User user = (User) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectOne("userMapper.queryUserByName", name);
		});
		return user;
	}

	@Override
	public List<User> queryAllUsers() {
		List<User> users = (List<User>) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectList("userMapper.queryAllUser");
		});
		return users;
	}
}

