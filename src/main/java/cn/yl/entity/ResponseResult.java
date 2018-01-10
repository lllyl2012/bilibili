package cn.yl.entity;

public class ResponseResult {
	private int state;
	private String message;
	private Object obj;
	public ResponseResult() {
		super();
	}
	public ResponseResult(int state, String message, Object obj) {
		super();
		this.state = state;
		this.message = message;
		this.obj = obj;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "ManagerPage [state=" + state + ", message=" + message + ", obj=" + obj + "]";
	}
	
}
