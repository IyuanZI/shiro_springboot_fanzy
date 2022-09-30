/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-24 10:54
 **/
package fanzy.top.shiro_springboot_fanzy.controller;

import fanzy.top.shiro_springboot_fanzy.entity.Permission;
import fanzy.top.shiro_springboot_fanzy.service.permissionService;
import fanzy.top.shiro_springboot_fanzy.service.userService;
import fanzy.top.shiro_springboot_fanzy.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/admin")
@RestController
public class AdminController {
	@Resource
	private permissionService permissionService;

	@Resource
	private userService userService;

	@GetMapping("/allUsers")
	public Result queryAllUsers() {
		return Result.success(userService.queyruAllUsers());
	}

	@PostMapping("/addPerm")
	public Result addPerm(@RequestBody Permission permission) {
		return Result.success(permissionService.addPerm(permission));
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

