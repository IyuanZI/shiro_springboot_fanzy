package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
	private String permissionId;
	private String permissionName;
	private String permissionUrl;
	private String permissionPerms;

	@Override
	public String toString() {
		return "Permission----{" +
				"permissionId='" + permissionId + '\'' +
				", permissionName='" + permissionName + '\'' +
				", permissionUrl='" + permissionUrl + '\'' +
				", permissionPerms='" + permissionPerms + '\'' +
				'}';
	}
}