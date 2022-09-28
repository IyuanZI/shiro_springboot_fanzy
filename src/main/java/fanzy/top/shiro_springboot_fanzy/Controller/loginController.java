/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-27 11:35
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.userService;
import fanzy.top.shiro_springboot_fanzy.Utils.HttpStatus;
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
	private static Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	private userService userService;

	@PostMapping("/login")
	public Result checkLogin(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
		} catch (UnknownAccountException UE) {
			// 用户名不存在
			UE.printStackTrace();
			return new Result(null, HttpStatus.NOT_FOUND.code(), HttpStatus.NOT_FOUND.getReasonPhrase());
		} catch (IncorrectCredentialsException IE) {
			// 密码错误
			IE.printStackTrace();
			return new Result(null, HttpStatus.FORBIDDEN.code(), HttpStatus.FORBIDDEN.getReasonPhrase());
		}
		System.out.println(currentUser.isPermitted("user_deleteFile"));


		User user = (User) currentUser.getPrincipal();
		logger.info(user.toString());
		return new Result(userService.queryUserByName(username), 200, "登录成功");
	}

	@PostMapping("/regist")
	public Result regist(@RequestBody User user) {
		logger.info(user.toString());
		// 使用username作为盐值
		Object salt = ByteSource.Util.bytes(user.getUsername());
		String newPassword = new SimpleHash("MD5", user.getPassword(), salt, 3).toHex();
		user.setPassword(newPassword);
		System.out.println(newPassword);
		// 注册成功
		if (userService.addUser(user) == 1) {
			return new Result(userService.queryUserByName(user.getUsername()), 200, "欢迎您，" + user.getUsername());
		}
		return new Result(null, HttpStatus.NOT_MODIFIED.code(), HttpStatus.NOT_MODIFIED.getReasonPhrase());
	}

	@GetMapping("/unauth")
	public String unauth() {
		return "unauth";
	}
}

