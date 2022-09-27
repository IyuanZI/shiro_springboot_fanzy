/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-27 11:35
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.User;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
			return new Result(null, 403, "用户名不存在");
		} catch (IncorrectCredentialsException IE) {
			// 密码错误
			IE.printStackTrace();
			return new Result(null, 403, "密码错误");
		}
		System.out.println(currentUser.isPermitted("user_deleteFile"));


		User user = (User) currentUser.getPrincipal();
		logger.info(user.toString());
		return new Result(userService.queryUserByName(username), 200, "登录成功");
	}


	@GetMapping("/unauth")
	public String unauth(){
		return "unauth";
	}

}

