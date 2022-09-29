package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.util.Date;
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