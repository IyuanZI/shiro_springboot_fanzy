package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}