package fanzy.top.shiro_springboot_fanzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
	private String username;
	private String permissionId;
	private String permissionName;
	private String permissionUrl;
	private String permissionPerms;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;
	private Boolean permissionOwner;

}