package cn.csbe.web.cms.auth.bean;

import org.springframework.util.DigestUtils;


public class UserPassword {

	private Long userId;	//bigint not null,
	private String username; //登录时候用来存放用户名
	private String phone;	//varchar(16) not null default '' comment '电话',
	private String email;	//varchar(50) not null default '' comment '邮箱',
	private String pwd;		//  varchar(60) not null default '' comment '用户密码',
	private String token;//用户令牌
	
	private String roleId;//roleId
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {

		return DigestUtils.md5DigestAsHex((pwd+"/csbe!@#%$^ASD").getBytes());
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
