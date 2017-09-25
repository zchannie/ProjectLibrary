package cn.csbe.web.cms.common.bean;

import java.io.Serializable;

/**
 * 分装了分页所需的参数
 * 
 * @Description TODO
 */
public class Page implements Serializable {

	/**
	 * 起始索引
	 */
	private Integer beginIndex = 0;

	/**
	 * 每页显示最大记录数，默认显示10条
	 */
	private Integer rows = 10;

	/**
	 * 排序字段
	 */
	private String sort;

	/**
	 * 排序规则默认desc降序
	 */
	private String order = "desc";
	
	private int page = 1;

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getBeginIndex() {
		this.beginIndex = (page-1)*rows;
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getRows() {
		return this.rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		// 转换成小写，mapper文件，判断的时候就不存在大小写问题了
		if (this.sort != null) {
			return this.sort.toLowerCase();
		}
		return null;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
