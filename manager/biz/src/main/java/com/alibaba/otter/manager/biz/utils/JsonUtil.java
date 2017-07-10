package com.alibaba.otter.manager.biz.utils;

import com.alibaba.fastjson.JSON;

public abstract class JsonUtil {
	public static <T> T unmarshalFromString(String json, Class<T> targetClass) {
        return (T) JSON.parseObject(json, targetClass);// 默认为UTF-8
    }
	public static String marshalToString(Object obj) {
        return JSON.toJSONString(obj); // 默认为UTF-8
    }
}
