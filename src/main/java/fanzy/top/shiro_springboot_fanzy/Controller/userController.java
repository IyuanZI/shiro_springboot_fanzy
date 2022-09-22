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
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
	@Autowired
	private userService userService;

	@GetMapping("/user")
	public Result queryUserByName(@RequestParam String name) {
		return new Result(userService.queryUserByName(name), 200, "");
	}

	@GetMapping("/allUsers")
	public Result queryAllUsers() {
		Subject currentUser = SecurityUtils.getSubject();
		return new Result(userService.queyruAllUsers(), 200, "");
	}
}

