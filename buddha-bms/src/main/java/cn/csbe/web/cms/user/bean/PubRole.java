package cn.csbe.web.cms.user.bean;

public class PubRole {
	private Integer roleId;
	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "PubRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
