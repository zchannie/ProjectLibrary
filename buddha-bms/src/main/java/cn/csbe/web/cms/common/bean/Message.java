package cn.csbe.web.cms.common.bean;

public class Message {

	public Message(){}
	public Message(boolean state,String message)
	{
		this.state = state;
		this.message = message;
	}
	private boolean state;
	
	private String message;

	public boolean isState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
