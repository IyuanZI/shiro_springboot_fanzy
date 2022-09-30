package fanzy.top.shiro_springboot_fanzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Fanzy
 * @version V1.0
 * @date 2022-08-10 17:34
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -8736616045315083846L;
	@Id
	private Integer id;
	private Integer userId;
	private String username;
	private String password;
	private Integer roleId;
	private String roleName;
	private String email;
	private String phone;
	private int sex;
	private int age;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;
	private String permissionId;
	private String permissionName;
	private String permissionUrl;
	private String permissionPerms;


	@Override
	public String toString() {
		return "User=={" +
				"id=" + id +
				", userId=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", roleId='" + roleId + '\'' +
				", roleName='" + roleName + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", sex=" + sex +
				", age=" + age +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", lastLoginTime=" + lastLoginTime +
				", permissionId='" + permissionId + '\'' +
				", permissionName='" + permissionName + '\'' +
				", permissionUrl='" + permissionUrl + '\'' +
				", permissionPerms='" + permissionPerms + '\'' +
				'}';
	}
}