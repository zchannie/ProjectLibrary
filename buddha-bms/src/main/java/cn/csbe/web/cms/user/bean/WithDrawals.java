package cn.csbe.web.cms.user.bean;

import java.math.BigDecimal;

import cn.csbe.web.cms.common.bean.Page;

public class WithDrawals extends Page{

	private Integer wid;//主键
	private Integer userId;//用户id
	private Integer cardId;//卡id
	private BigDecimal money;//金额
	private String cardType;//银行卡类型
	private Integer status;//提现状态
	private String createtime;//创建时间
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
