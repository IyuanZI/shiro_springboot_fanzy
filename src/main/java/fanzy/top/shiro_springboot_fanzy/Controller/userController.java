/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:03
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Config.mybatis;
import fanzy.top.shiro_springboot_fanzy.Dao.userDao;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
	@Autowired
	private userService userService;

	@GetMapping("/apiTest")
	public String apiTest() {
		String res = (String) mybatis.excuteQuery(sqlSession -> {
			return sqlSession.selectOne("userMapper.queryAllUser");
		});
		return res;
	}

	@GetMapping("/allUsers")
	public List<User> queryAllUsers() {
		List<User> res = userService.queyruAllUsers();
		return res;
	}
}

