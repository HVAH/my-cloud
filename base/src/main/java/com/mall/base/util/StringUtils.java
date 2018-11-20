package com.mall.base.util;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author Cobain
 * @category 字符串处理工具类
 * @version 2016-09-28 初始化
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final String[] chars = new String[] { //
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", //
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", //
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" //
	};

	/**
	 * 正则表达式：验证汉字
	 */
	public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{0,}$";
	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^1\\d{10}$";
	/**
	 * 正则表达式：验证邮箱
	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	/**
	 * 正则表达式：登录密码验证
	 */
	public static final String REGEX_PASSWORD = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![!@#$%\\^&*\\(\\)]+$)[\\da-zA-Z!@#$%\\^&*\\(\\)]{6,18}$";
	/**
	 * 正则表达式：支付密码
	 */
	public static final String REGEX_PAYPWD = "^\\d{6}$";

	/**
	 * 正则表达式：邮政编码
	 */
	public static final String REGEX_ZIP = "^\\d{6}$";

	/**
	 * 正则表达式：座机
	 */
	public static final String REGEX_FixedPhone = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" + "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
	/**
	 * 正则表达式：QQ
	 */
	public static final String REGEX_QQ = "^\\d{5,11}$";

	/**
	 * 系统UUID
	 * 
	 * @return
	 */
	public static String systemUuid() {
		return String.valueOf(UUID.randomUUID());
	}

	/**
	 * 不带符号的UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return systemUuid().replace("-", "");
	}

	/**
	 * 8位UUID
	 * 
	 * @return
	 */
	public static String shortUuid() {
		final StringBuffer shortBuffer = new StringBuffer();
		final String uuid = uuid();
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	private final static String RAND_STR = "012356678899";
	private final static Random RANDOM = new Random();

	/**
	 * 获取随机字符串
	 * 
	 * @param len
	 * @return
	 */
	public static String randomStr(final Integer len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(RAND_STR.charAt(RANDOM.nextInt(RAND_STR.length())));
		}
		return sb.toString();
	}

	/**
	 * 校验汉字
	 * 
	 * @param chinese
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isChinese(String chinese) {
		return Pattern.matches(REGEX_CHINESE, chinese);
	}

	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isMobile(String mobile) {
		return Pattern.matches(REGEX_MOBILE, mobile);
	}

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isEmail(String email) {
		return Pattern.matches(REGEX_EMAIL, email);
	}

	/**
	 * 校验登录密码
	 * 
	 * @param password
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isLegalPwd(String password) {
		return Pattern.matches(REGEX_PASSWORD, password);
	}

	/**
	 * 校验支付密码
	 * 
	 * @param password
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isLegalPayPwd(String password) {
		return Pattern.matches(REGEX_PAYPWD, password);
	}

	/**
	 * 校验邮政编码
	 * 
	 * @param zip
	 * @return 校验通过返回true，否则返回false
	 */
	public static Boolean isZip(String zip) {
		return Pattern.matches(REGEX_ZIP, zip);
	}

	/**
	 * 区号+座机号码+分机号码
	 * 
	 * @param fixedPhone
	 * @return
	 */
	public static Boolean isFixedPhone(String fixedPhone) {
		return Pattern.matches(REGEX_FixedPhone, fixedPhone);
	}

	/**
	 * QQ号码验证
	 * 
	 * @param qq
	 * @return
	 */
	public static Boolean isQq(String qq) {
		return Pattern.matches(REGEX_QQ, qq);
	}
}
