package com.alibaba.otter.manager.biz.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 功能：MD5加密工具类
 */
public class MD5Util {
	/**
	 * 1.对文本进行32位小写MD5加密
	 */
	public static String StringToMD5L32(String plainText) {

		// 首先判断是否为空
		if (StringUtil.isNoneEmpty(plainText)) {
			try {
				// 首先进行实例化和初始化
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 得到一个操作系统默认的字节编码格式的字节数组
				byte[] btInput = plainText.getBytes();
				// 对得到的字节数组进行处理
				md.update(btInput);
				// 进行哈希计算并返回结果
				byte[] btResult = md.digest();
				// 进行哈希计算后得到的数据的长度
				StringBuffer sb = new StringBuffer();
				for (byte b : btResult) {
					int bt = b & 0xff;
					if (bt < 16) {
						sb.append(0);
					}
					sb.append(Integer.toHexString(bt));
				}
				return sb.toString();
			} catch (NoSuchAlgorithmException e) {
			}
		}
		return null;
	}
}
