/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-24 10:54
 **/
package fanzy.top.shiro_springboot_fanzy.Controller;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
import fanzy.top.shiro_springboot_fanzy.Service.permissionService;
import fanzy.top.shiro_springboot_fanzy.Utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class permissionController {
	@Autowired
	private permissionService permissionService;

	@GetMapping("/scan")
	public Result allPermissions_own(@RequestParam String name) {
		return new Result(permissionService.allPermissions_own(name), 200, "查询成功");
	}

	@PostMapping("/addPerm")
	public Result addPerm(@RequestBody Permission permission) {
		return new Result(permissionService.addPerm(permission), "操作成功");
	}
}

