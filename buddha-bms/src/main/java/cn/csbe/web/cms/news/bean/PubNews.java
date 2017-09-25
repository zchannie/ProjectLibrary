package cn.csbe.web.cms.news.bean;

import cn.csbe.web.cms.common.bean.Page;
/**
 * 新闻/活动
 * @author chZhou
 * 创建时间：2017-6-29下午4:23:04
 * 描述：
 */
public class PubNews extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer newsid;
	private String newsTitle;
	private String publishDate;
	private String picture;
	private Integer status;
	private Integer type;  //0 壁纸  1.高僧大德
	private String newsIntroduction;//简介
	private String htmlUrl;//html链接
	
	private int previewTotal; //预览总数
	private String param;//临时参数，存原来htmlurl
	
	
   
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public int getPreviewTotal() {
		return previewTotal;
	}

	public void setPreviewTotal(int previewTotal) {
		this.previewTotal = previewTotal;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getNewsIntroduction() {
		return newsIntroduction;
	}

	public void setNewsIntroduction(String newsIntroduction) {
		this.newsIntroduction = newsIntroduction;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}


	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
