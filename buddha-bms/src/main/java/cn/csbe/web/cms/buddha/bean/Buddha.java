package cn.csbe.web.cms.buddha.bean;

import cn.csbe.web.cms.common.bean.Page;
/**
 * 佛教bean
 * @author chZhou
 *
 */
public class Buddha extends Page {

	private static final long serialVersionUID = 1L;
	private String buddhaId;
	private String buddhaName;//佛像名称
	private String imgUrl;         //图片路径url
	private String content;      //描述
	private String createTime;
	private String updateTime;
	private int status;
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBuddhaId() {
		return buddhaId;
	}
	public void setBuddhaId(String buddhaId) {
		this.buddhaId = buddhaId;
	}
	public String getBuddhaName() {
		return buddhaName;
	}
	public void setBuddhaName(String buddhaName) {
		this.buddhaName = buddhaName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
