package cn.csbe.web.cms.book.bean;

import cn.csbe.web.cms.common.bean.Page;
/**
 * Title：PubBook
 * Description：经文/书
 * @author chZhou
 * @date    2017-7-3
 */
public class PubBook extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer bookId;
	private String bookTitle;
	private String bookIntroduction;//简介
	private String bookContent;//内容
	private String publishDate;
	private String picture;
	private Integer status;
	private String htmlUrl;//html链接
	
	private String param;//临时参数，存原来htmlurl
	
	
   
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookIntroduction() {
		return bookIntroduction;
	}

	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

}
