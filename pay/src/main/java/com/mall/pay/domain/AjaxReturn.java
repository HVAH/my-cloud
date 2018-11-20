package com.mall.pay.domain;

public class AjaxReturn {
	protected Integer code = 200;
	protected String info;
	protected Object data;

	public AjaxReturn() {
		super();
	}

	public AjaxReturn(Integer code, String info, Object data) {
		super();
		this.code = code;
		this.info = info;
		this.data = data;
	}

	public AjaxReturn(Integer code, String info) {
		super();
		this.code = code;
		this.info = info;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
