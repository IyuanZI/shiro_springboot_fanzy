/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:03
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Service.userService;
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class userController {
	private static Logger logger = LoggerFactory.getLogger(userController.class);

	@Autowired
	private userService userService;

	@GetMapping("/user")

	public Result queryUserByName(@RequestParam String name) {
		logger.info(userService.queryUserByName(name).toString());
		return new Result(userService.queryUserByName(name), 200, "");
	}

	@GetMapping("/allUsers")
	// @RequiresPermissions("admin:read")
	public Result queryAllUsers() {
		Subject currentUser = SecurityUtils.getSubject();
		return new Result(userService.queyruAllUsers(), 200, "");
	}


	@PostMapping("/login")
	public Result checkLogin(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
		} catch (UnknownAccountException UE) {
			// 用户名不存在
			UE.printStackTrace();
			return new Result(null, 202, "用户名不存在");
		} catch (IncorrectCredentialsException IE){
			// 密码错误
			IE.printStackTrace();
			return new Result(null, 201, "密码错误");
		}
		return new Result(userService.queryUserByName(username),200,"登录成功");
	}
}

