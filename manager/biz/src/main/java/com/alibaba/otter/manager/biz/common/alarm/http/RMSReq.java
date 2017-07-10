package com.alibaba.otter.manager.biz.common.alarm.http;

public class RMSReq {
	private String token;
	private int encode;
	private RMSReqData data;
	public String getToken() {
		return token;
	}
	public int getEncode() {
		return encode;
	}
	public RMSReqData getData() {
		return data;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setEncode(int encode) {
		this.encode = encode;
	}
	public void setData(RMSReqData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RMSReq [token=" + token + ", encode=" + encode + ", data=" + data + "]";
	}
}
