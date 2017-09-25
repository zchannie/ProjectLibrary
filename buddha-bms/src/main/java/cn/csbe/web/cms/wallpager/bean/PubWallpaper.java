package cn.csbe.web.cms.wallpager.bean;

import cn.csbe.web.cms.common.bean.Page;
/**
 * @author chZhou
 * 创建时间：2017-6-19下午4:39:01
 * 描述：主题bean
 */
public class PubWallpaper extends Page {

	private static final long serialVersionUID = 1L;
	
	  private int  id; //壁纸id,
	  private String picture; //原图路径
	  private String thumbnail;//缩略图
	  private int pid; //主题父id
	  private int zanTotal; //未登录用户赞总数
	  private int collectionTotal; //未登录用户的下载总数
	  private int downloadTotal; //下载总数
	  private int status;
	  
	  
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getZanTotal() {
		return zanTotal;
	}
	public void setZanTotal(int zanTotal) {
		this.zanTotal = zanTotal;
	}
	public int getCollectionTotal() {
		return collectionTotal;
	}
	public void setCollectionTotal(int collectionTotal) {
		this.collectionTotal = collectionTotal;
	}
	public int getDownloadTotal() {
		return downloadTotal;
	}
	public void setDownloadTotal(int downloadTotal) {
		this.downloadTotal = downloadTotal;
	}
	public PubWallpaper(int id, String picture, int pid, int zanTotal,
			int collectionTotal, int downloadTotal) {
		super();
		this.id = id;
		this.picture = picture;
		this.pid = pid;
		this.zanTotal = zanTotal;
		this.collectionTotal = collectionTotal;
		this.downloadTotal = downloadTotal;
	}
	public PubWallpaper() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
