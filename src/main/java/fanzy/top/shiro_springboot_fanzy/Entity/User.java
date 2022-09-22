/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 12:00
 **/
package fanzy.top.shiro_springboot_fanzy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Value("id")
	private int id;
	@Value("user_id")
	private String userId;
	@Value("username")
	private String userName;
	@Value("password")
	private String password;
	@Value("salt")
	private String slat;
	@Value("email")
	private String email;
	@Value("phone")
	private String phone;
	@Value("sex")
	private int sex;
	@Value("age")
	private int age;
	@Value("status")
	private int status;
	@Value("create_time")
	private Date createTime;
	@Value("update_time")
	private Date updateTime;
	@Value("last_login_time")
	private Date lastLoginTime;
}

