package cn.csbe.web.cms.common.bean;

import java.util.List;

public class QueryResult {

	// 总记录数
	private Long totalSize;
	// 查询到的对象集合
	private List list;

	public Long getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public List getList() {
		return this.list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
