/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:03
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
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

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class userController {
	private static Logger logger = LoggerFactory.getLogger(userController.class);
	@Resource
	private permissionService permissionService;
	@Resource
	private userService userService;

	@GetMapping("/currentUser")
	public Result queryUserByName(@RequestParam String name) {
		return new Result(userService.queryUserByName(name), 200, "操作成功");
	}

	@GetMapping("/scanPerms")
	public Result allPermissions_own(@RequestParam String name) {
		System.out.println(permissionService.allPermissions(name));
		if (permissionService.allPermissions(name) != null) {
			return new Result(permissionService.allPermissions(name), 200, "查询成功");
		}
		return Result.fail(null, 404, "查询失败");
	}

	@GetMapping("/addFile")
	public Result addFile() {
		return new Result("/file/add", 200, "添加文件");
	}

	@PostMapping("/deleteFile")
	public Result deleteFile() {
		return new Result("/file/delete", 200, "删除文件");
	}

	@GetMapping("/movePerm")
	public Result movePerm(@RequestParam String username, @RequestParam String permId) {
		permissionService.movePerm(username, permId);
		return new Result(permissionService.allPermissions(username), 200, "操作成功");
	}

}

