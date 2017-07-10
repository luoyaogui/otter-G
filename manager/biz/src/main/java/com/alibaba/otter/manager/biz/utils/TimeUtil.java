package com.alibaba.otter.manager.biz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class TimeUtil {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf0=new SimpleDateFormat("<yyyy-MM-dd HH:mm:ss>");
	
	public static String getTime(){
		return sdf.format(new Date());
	}
	
	public static String getTime0(){
		return sdf0.format(new Date());
	}
	
	public static String getTime(long time){
		return sdf.format(new Date(time));
	}
}
