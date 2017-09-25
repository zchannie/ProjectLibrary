package cn.csbe.web.cms.pub.bean;

import org.apache.commons.lang.StringUtils;

import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.bean.Page;

public class PubCategory extends Page {

	private Integer categoryId;//           int not null auto_increment comment '分类ID',
	private String categoryName;//         varchar(50) not null default '' comment '分类名称',
	private Integer parentId;//             int not null default -1 comment '父id',
	private String picture;//             varchar(150) not null default '' comment '分类图标',
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer get_parentId() {
		if(parentId == 0)
			return null;
		return parentId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getPicture() {
		if(StringUtils.isNotEmpty(this.picture))
			return CSBE.file_server+picture;
		return "";
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
