package cn.csbe.web.cms.user.bean;

import cn.csbe.web.cms.common.bean.Page;

public class PubUser extends Page {
	private Integer userId;
	private String username;
	private String nickname;
	private String picture;
	private String phone;
	private Integer roleId;
	private Integer status;
	private String roleNames;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	@Override
	public String toString() {
		return "PubUser [userId=" + userId + ", username=" + username + ", nickname=" + nickname + ", picture="
				+ picture + ", phone=" + phone + ", roleId=" + roleId + ", status=" + status + ", roleNames="
				+ roleNames + "]";
	}

}
