package com.alibaba.otter.manager.biz.common.alarm.http;

import java.util.Arrays;

/**
 * @author yaoguiluo
 * 2017年3月6日 下午5:58:56
 * 根据高亚鹏提供的文档进行定义
 */
public class RMSReqData {
	
	public static class Content {
		private String info;

		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		@Override
		public String toString() {
			return "Content [info=" + info + "]";
		}
	}
	private String point_code;//监控点简码
	private String error_code;//错误简码
	private String notice_time;//发生时间，格式统一使用北京时间：2016-06-19 15:20:21
	private Content content;//内容，可以是数组也可以是字符串，目前暂定为数组，内容4万字符以内
	private int level;//级别
	private int is_test;//是否自检，1是  0否
	private String server_ip;//服务器ip
	private String server_name;//服务器标识名
	
	public String getPoint_code() {
		return point_code;
	}
	public String getError_code() {
		return error_code;
	}
	public String getNotice_time() {
		return notice_time;
	}
	public Content getContent() {
		return content;
	}
	public int getLevel() {
		return level;
	}
	public int getIs_test() {
		return is_test;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setIs_test(int is_test) {
		this.is_test = is_test;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	@Override
	public String toString() {
		return "RMSParameters [point_code=" + point_code + ", error_code=" + error_code + ", notice_time=" + notice_time
				+ ", content=" + content + ", level=" + level + ", is_test=" + is_test + ", server_ip="
				+ server_ip + ", server_name=" + server_name + "]";
	}
}
