/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:03
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.User;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Service.userService;
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
	private static Logger logger = LoggerFactory.getLogger(userController.class);
	@Autowired
	private permissionService permissionService;
	@Autowired
	private userService userService;

	@GetMapping("/user/currentUser")
	public Result queryUserByName(@RequestParam String name) {
		return new Result(userService.queryUserByName(name), 200, "操作成功");
	}

	@GetMapping("/user/scanPerms")
	public Result allPermissions_own(@RequestParam String name) {
		return new Result(permissionService.allPermissions_own(name), 200, "查询成功");
	}

	@GetMapping("/user/addFile")
	public Result addFile() {
		return new Result("/file/add", 200, "添加文件");
	}

	@PostMapping("/user/deleteFile")
	public Result deleteFile() {
		return new Result("/file/delete", 200, "删除文件");
	}

}

