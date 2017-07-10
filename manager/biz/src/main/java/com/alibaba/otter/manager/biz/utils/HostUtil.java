package com.alibaba.otter.manager.biz.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostUtil {
	static InetAddress netAddress;
	
	static{
		try{  
			netAddress = InetAddress.getLocalHost();  
        }catch(UnknownHostException e){  
        } 
	}
  
    public static String getHostIp(){  
        if(null == netAddress){  
            return null;  
        }  
        String ip = netAddress.getHostAddress(); //get the ip address  
        return ip;  
    }  
  
    public static String getHostName(){  
        if(null == netAddress){  
            return null;  
        }  
        String name = netAddress.getHostName(); //get the host address  
        return name;  
    } 
}
