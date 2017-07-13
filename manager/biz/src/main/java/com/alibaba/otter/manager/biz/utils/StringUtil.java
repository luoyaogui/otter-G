package com.alibaba.otter.manager.biz.utils;

public abstract class StringUtil {

	// 验证字符串不是null、空格填充的字符串、tab填充的字符串
	public static boolean isNoneEmpty(String str){
		if(null == str)
			return false;
		if(0 == str.length()){
			return false;
		}
		return str.trim().replaceAll("\\s{1,}", "").length() > 0;//	^\\s*$
	}
	
	/* canal的信息如下
	 * {"@type":"com.alibaba.otter.canal.protocol.position.LogPosition","identity":{"slaveId":-1,"sourceAddress":{"address":"*","port":3306}},"postion":{"included":false,"journalName":"mysql-bin.000015","position":719176606,"serverId":30245,"timestamp":1488417704000}}
	 * */
	public static long getPositionTime(String position){//
		if(isNoneEmpty(position) && position.length()>17)
			try{
				return Long.parseLong(position.substring(position.length()-15, position.length()-2));
			}catch(Throwable e){}
		return 0;
	}
}
