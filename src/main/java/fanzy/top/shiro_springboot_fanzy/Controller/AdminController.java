/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-24 10:54
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Service.userService;
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private permissionService permissionService;

	@Autowired
	private userService userService;

	@GetMapping("/allUsers")
	public Result queryAllUsers() {
		return new Result(userService.queyruAllUsers(), 200, "");
	}

	@PostMapping("/addPerm")
	public Result addPerm(@RequestBody Permission permission) {
		return new Result(permissionService.addPerm(permission), "操作成功");
	}

	@GetMapping("/addUser")
	public String userAdd() {
		return "/user/add";
	}

	@GetMapping("/moveUser")
	public String userMove() {
		return "/user/move";
	}

	@GetMapping("/modifyUser")
	public String userModify() {
		return "/user/modify";
	}
}

