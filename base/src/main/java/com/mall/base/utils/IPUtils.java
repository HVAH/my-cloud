package com.mall.base.utils;

/**
 * IP工具包
 * 
 * @author Cobain
 * @category 描述功能
 * @version 2016-12-02 初始化
 */
public class IPUtils {

	/**
	 * 对IP进行编码
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static Long encoded(String ipAddress) {
		long result = 0;
		String[] ipAddressInArray = ipAddress.split("\\.");
		for (int i = 3; i >= 0; i--) {
			long ip = Long.parseLong(ipAddressInArray[3 - i]);
			result |= ip << (i * 8);
		}
		return result;
	}

	/**
	 * 对IP进行解码
	 * 
	 * @param ip
	 * @return
	 */
	public static String decoded(Long ip) {
		StringBuilder sb = new StringBuilder(15);
		for (int i = 0; i < 4; i++) {
			sb.insert(0, Long.toString(ip & 0xff));
			if (i < 3) {
				sb.insert(0, '.');
			}
			ip = ip >> 8;
		}
		return sb.toString();
	}
}
