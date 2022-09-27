package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.util.Date;
@Data
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

	@Override
	public String toString() {
		return "Permission----{" +
				"username='" + username + '\'' +
				"permissionId='" + permissionId + '\'' +
				", permissionName='" + permissionName + '\'' +
				", permissionUrl='" + permissionUrl + '\'' +
				", permissionPerms='" + permissionPerms + '\'' +
				", permissionOwner='" + permissionOwner + '\'' +
				", createTime='" + createTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				", lastLoginTime='" + lastLoginTime + '\'' +
				'}';
	}
}