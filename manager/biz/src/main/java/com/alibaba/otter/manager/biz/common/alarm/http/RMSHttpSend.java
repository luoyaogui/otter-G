package com.alibaba.otter.manager.biz.common.alarm.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.otter.manager.biz.common.alarm.http.RMSReqData.Content;
import com.alibaba.otter.manager.biz.utils.HostUtil;
import com.alibaba.otter.manager.biz.utils.JsonUtil;
import com.alibaba.otter.manager.biz.utils.MD5Util;
import com.alibaba.otter.manager.biz.utils.StringUtil;
import com.alibaba.otter.manager.biz.utils.TimeUtil;


/**
 * @author yaoguiluo
 * 2017年3月4日 上午9:37:44
 * 报警服务类
 */
public class RMSHttpSend {
	
	private static final Logger         logger = LoggerFactory.getLogger(RMSHttpSend.class);
	private static String Split = ",";//格式 ProjectCode,Token,PointCode,ErrCode,ErrLevel
	private static String HB = "HeartBeat";
	private static String EQ = "=";
    private static int CodeLength = 5;
	
	public static void push(String httpUrl,String code, String msg){
		api(httpUrl,code,false,msg);
	}
	public static void heartBeat(String httpUrl,String code){
		api(httpUrl,code,true,HB);
	}
	private static void api(String httpUrl, String code, boolean isHeartBeat, String msg){
		if(StringUtil.isNoneEmpty(code)){
			String[] segs = code.split(Split);
			if(segs.length == CodeLength){
				String params = getAlarmParam(isHeartBeat, segs[1], segs[2], segs[3], segs[4], msg);
				if(params == null){
					logger.error("[RMSHttpSend-api exception] " + code);
					return;
				}
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost methodName = new HttpPost(httpUrl+EQ+segs[0]);
				methodName.addHeader("Content-type","application/json; charset=utf-8");
				methodName.setHeader("Accept", "application/json");
				try {
					methodName.setEntity(new StringEntity(params));
					httpClient.execute(methodName);
//					HttpResponse response = httpClient.execute(methodName);
//					logger.info("RMSHttpSend statusCode : " + response.getStatusLine().getStatusCode() + "["+paramEntity+"]");
				} catch (Throwable e) {
					logger.error("[" + params + "] " + e.getMessage());
				}
				httpClient = null;
				methodName = null;
			}else{
				logger.error("[RMSHttpSend-api code length exception] " + code.length()+"   "+code);
			}
		}else{
			logger.error("[RMSHttpSend-api code is null] " + code);
		}
	}

	private static String getAlarmParam(boolean isHeartBeat, String token, String pointCode, String errorCode, String level, String msg){
		RMSReq req = new RMSReq();
		
		RMSReqData param = new RMSReqData();
		param.setPoint_code(pointCode);
		param.setError_code(errorCode);
		param.setNotice_time(TimeUtil.getTime());
		
		Content cont = new Content();
		cont.setInfo(msg);
		
		param.setContent(cont);
		try {
			param.setLevel(Integer.parseInt(level));
		}catch (NumberFormatException e){
			return null;
		}
		param.setIs_test(isHeartBeat?1:0);
		param.setServer_ip(HostUtil.getHostIp());
		param.setServer_name(HostUtil.getHostName());
		
		req.setToken(MD5Util.StringToMD5L32(token+JsonUtil.marshalToString(param)));
		req.setEncode(0);
		req.setData(param);
		
		return JsonUtil.marshalToString(req);
	}
}
