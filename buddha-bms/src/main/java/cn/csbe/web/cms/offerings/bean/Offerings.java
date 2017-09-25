package cn.csbe.web.cms.offerings.bean;

import cn.csbe.web.cms.common.bean.Page;

/**
 * 供品bean
 * @author chZhou
 *
 */
public class Offerings extends Page {
	private Integer offeringsId;     //主键id
	private String offeringsName;//供品名称
	private String imgUrl;           //供品图片url
	private Integer meritCoin;     // 功德币
	private Integer type;         // 供品类型：0. 香  1. 水果
	private String createTime;
	private String updateTime;
	private Integer status; // 状态
	
	private String content;//供品内容
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getOfferingsId() {
		return offeringsId;
	}
	public void setOfferingsId(Integer offeringsId) {
		this.offeringsId = offeringsId;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getOfferingsName() {
		return offeringsName;
	}
	public void setOfferingsName(String offeringsName) {
		this.offeringsName = offeringsName;
	}
	public Integer getMeritCoin() {
		return meritCoin;
	}
	public void setMeritCoin(Integer meritCoin) {
		this.meritCoin = meritCoin;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


}
