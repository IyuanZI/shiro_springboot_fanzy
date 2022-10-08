
package fanzy.top.shiro_springboot_fanzy.controller;

import fanzy.top.shiro_springboot_fanzy.entity.User;
import fanzy.top.shiro_springboot_fanzy.service.PermissionService;
import fanzy.top.shiro_springboot_fanzy.service.UserService;
import fanzy.top.shiro_springboot_fanzy.utils.HttpStatus;
import fanzy.top.shiro_springboot_fanzy.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-27 11:35
 **/
@RestController
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource
	private UserService userService;
	@Resource
	private PermissionService permissionService;

	/**
	 * 登录
	 *
	 * @param username
	 * @param password
	 * @return fanzy.top.shiro_springboot_fanzy.Utils.Result
	 * @author fanzy
	 * @date 2022-09-30 15:03
	 */
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
		return new Result(userService.queryUserByName(token.getUsername()), 200, "登录成功");
	}

	/**
	 * 注册
	 *
	 * @param user
	 * @return fanzy.top.shiro_springboot_fanzy.Utils.Result
	 * @author fanzy
	 * @date 2022-09-30 15:04
	 */
	@PostMapping("/regist")
	public Result regist(@RequestBody User user) {
		logger.info(user.toString());
		// 使用username作为盐值
		Object salt = ByteSource.Util.bytes(user.getUsername());
		String newPassword = new SimpleHash("MD5", user.getPassword(), salt, 3).toHex();
		user.setPassword(newPassword);
		userService.addUser(user);
		// 注册成功
		if (user == null) {
			Result.fail(false, 500, "注册失败");
		}
		return new Result(200, "欢迎您，" + user.getUsername());
	}

	/**
	 * 注册
	 *
	 * @param session
	 * @return fanzy.top.shiro_springboot_fanzy.Utils.Result
	 * @author fanzy
	 * @date 2022-09-30 15:05
	 */
	@GetMapping("/logout")
	public Result logout(HttpSession session) {
		session.invalidate();
		return Result.success(null);
	}

	/**
	 * 用户未授权
	 *
	 * @return java.lang.String
	 * @author fanzy
	 * @date 2022-09-30 15:05
	 */
	@GetMapping("/unauth")
	public String unauth() {
		return "redirect:/unauth";
	}
}

