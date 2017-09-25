package cn.csbe.web.cms.wallpager.bean;

import cn.csbe.web.cms.common.bean.Page;
/**
 * @author chZhou
 * 创建时间：2017-6-19下午4:39:10
 * 描述：壁纸主题bean
 */
public class PubTheme extends Page {

	private static final long serialVersionUID = 1L;
	
	private int themeId; //主题id
	private String themeName; //主题名称
	private String themeContent ; //主题内容
	private String themeImg; //主题图片路径
	private int previewTotal; //预览总数
	private int zanTotal; //赞总数
	private int downloadTotal; //下载总数
	private int status; //状态  0 禁用 1正常
	private Integer type;//类型 0壁纸 1高僧 2人生 3运势 4素食
	private String createTime;//创建时间
	
    private String htmlUrl;//html链接
    private String param;//临时参数
    
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getHtmlUrl() {
		return htmlUrl;    
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getThemeContent() {
		return themeContent;
	}
	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}
	public String getThemeImg() {
		return themeImg;
	}
	public void setThemeImg(String themeImg) {
		this.themeImg = themeImg;
	}
	public int getPreviewTotal() {
		return previewTotal;
	}
	public void setPreviewTotal(int previewTotal) {
		this.previewTotal = previewTotal;
	}
	public int getZanTotal() {
		return zanTotal;
	}
	public void setZanTotal(int zanTotal) {
		this.zanTotal = zanTotal;
	}
	public int getDownloadTotal() {
		return downloadTotal;
	}
	public void setDownloadTotal(int downloadTotal) {
		this.downloadTotal = downloadTotal;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PubTheme(int themeId, String themeName, String themeContent,
			String themeImg, int previewTotal, int zanTotal, int downloadTotal,
			int status) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
		this.themeContent = themeContent;
		this.themeImg = themeImg;
		this.previewTotal = previewTotal;
		this.zanTotal = zanTotal;
		this.downloadTotal = downloadTotal;
		this.status = status;
	}
	public PubTheme() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
