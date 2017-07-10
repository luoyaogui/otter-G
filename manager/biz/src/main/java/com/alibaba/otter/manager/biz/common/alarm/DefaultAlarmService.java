package com.alibaba.otter.manager.biz.common.alarm;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.otter.manager.biz.common.alarm.http.RMSHttpSend;
import com.alibaba.otter.manager.biz.config.parameter.SystemParameterService;
import com.alibaba.otter.shared.common.model.config.parameter.SystemParameter;

/**
 * 发送报警
 * 
 * @author jianghang 2013-9-6 上午11:42:04
 * @since 4.2.2
 */
public class DefaultAlarmService extends AbstractAlarmService {

	private static final Logger         logger = LoggerFactory.getLogger(DefaultAlarmService.class);
	
    private SystemParameterService systemParameterService;
    private static ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
    private static String CodeSplit = ";";
    private static String HttpUrl = null;
    private static String HeartBeatCode = null;
    
    public void init() {
    	SystemParameter systemParameter = systemParameterService.find();
    	if(systemParameter == null) {
    		logger.error("systemParameter is null!");
    	}
    	
    	HttpUrl = systemParameter.getDefaultAlarmReceiver();
    	if(HttpUrl == null){
    		logger.error("HttpUrl is null!");
    	}
    	
    	HeartBeatCode = systemParameter.getAlarmReceiver();
    	if(HeartBeatCode == null){
    		logger.error("HeartBeatCode is null!");
    	} else {
			schedule.scheduleAtFixedRate(new Runnable(){
    			@Override
    			public void run() {
    				for(String code:HeartBeatCode.split(CodeSplit)){
    					try {
        					RMSHttpSend.heartBeat(HttpUrl, code);
        				} catch (Throwable e){
        				}
    				}
    			}
        	}, 5, 10, TimeUnit.MINUTES);
    	}
    }

    public void doSend(AlarmMessage data) throws Exception {
    	for(String code:data.getReceiveKey().split(CodeSplit)){
    		try{
        		RMSHttpSend.push(HttpUrl, code, data.getMessage());
        	} catch (Throwable e){
    		}
    	}
    }
    
    public void setSystemParameterService(SystemParameterService systemParameterService) {
        this.systemParameterService = systemParameterService;
        init();
    }

}
