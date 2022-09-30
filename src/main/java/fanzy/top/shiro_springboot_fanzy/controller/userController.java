
package fanzy.top.shiro_springboot_fanzy.controller;

import fanzy.top.shiro_springboot_fanzy.service.permissionService;
import fanzy.top.shiro_springboot_fanzy.service.userService;
import fanzy.top.shiro_springboot_fanzy.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:03
 **/
@RequestMapping("/user")
@RestController
public class userController {
	private static Logger logger = LoggerFactory.getLogger(userController.class);
	@Resource
	private permissionService permissionService;
	@Resource
	private userService userService;

	/**
	 * @param name
	 * @return fanzy.top.shiro_springboot_fanzy.Utils.Result
	 * @author fanzy
	 * @date 2022-09-30 14:41
	 */
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

