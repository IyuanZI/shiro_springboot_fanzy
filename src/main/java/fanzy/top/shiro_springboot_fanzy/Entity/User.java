package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author superzheng
 * @version V1.0
 * @date 2018年7月11日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -8736616045315083846L;
	@Id
	private Integer id;
	private Integer userId;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String phone;
	private int sex;
	private int age;
	private int status;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;
	private String permissionId;
	private String permissionName;
	private String permissionUrl;
	private String permissionPerms;

	@Override
	public String toString() {
		return "User---{" +
				"id=" + id +
				", userId=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", sex=" + sex +
				", age=" + age +
				", status=" + status +
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