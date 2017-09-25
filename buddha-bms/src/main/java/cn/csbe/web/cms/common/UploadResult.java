package cn.csbe.web.cms.common;

/**
 * 该类封装了，上传文件后的结果信息
 * @company 北京优贝在线网络科技有限公司
 * @ClassName UploadResult
 * @Description TODO
 * @author xiaoQiang web:www.miniing.com email:webmaster@miniing.com
 * @date 2012-11-6
 */
public class UploadResult{
	
	private int status;
	private String value;
	
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getValue() {
		
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}