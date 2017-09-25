package cn.csbe.web.cms.user.bean;

/**
 * 关系表
 * 
 * @author yangrui
 *
 */
public class UserRoleRelation {
	private Integer userId;
	private Integer roleId;
	private Integer status;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "UserRoleRelation [userId=" + userId + ", roleId=" + roleId + ", status=" + status + "]";
	}

}
