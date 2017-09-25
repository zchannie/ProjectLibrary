package cn.csbe.web.cms.auth.bean;

public class UserRoleMenu {
	private int relationId;
	private int userId;
	private int roleId;
	private int menuId;
	private String menuName;
	private String url;
	private String pmenuName;
	private int pmenuId;
	
	public int getMenuId() {
		return menuId;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPmenuName() {
		return pmenuName;
	}

	public void setPmenuName(String pmenuName) {
		this.pmenuName = pmenuName;
	}

	public int getPmenuId() {
		return pmenuId;
	}

	public void setPmenuId(int pmenuId) {
		this.pmenuId = pmenuId;
	}
}
