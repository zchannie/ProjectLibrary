package cn.csbe.web.cms.pub.bean;

public class PubCity {

	private Integer id;//                   int not null,
	private String name;//                varchar(40),
	private Integer pid;//                  int,
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}

}
