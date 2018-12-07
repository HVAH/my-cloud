package com.mall.base.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/11/7 10:44
 * @Version 1.0
 */
public final class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {

	private final static DateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
	private final static DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
	private final static DateFormat df3 = new SimpleDateFormat("HHmmss");

	/**
	 * 解析时间日期
	 *
	 * @param text
	 * @return
	 */
	public static Date parse(String text) {
		Date date = null;
		try {
			if (StringUtils.isNotBlank(text)) {
				text = StringUtils.replacePattern(text, "\\D", "");
				if (StringUtils.length(text) == 14) {
					date = df1.parse(text);
				} else if (StringUtils.length(text) == 8) {
					date = df2.parse(text);
				} else if (StringUtils.length(text) == 6) {
					date = df3.parse(text);
				}
			}
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 解析时间日期
	 *
	 * @param text
	 * @param def
	 * @return
	 */
	public static Date parse(String text, Date def) {
		Date date = parse(text);
		return date == null ? def : date;
	}

	/**
	 * 获取当前时间减去指定工作日之后的时间
	 *
	 * @param workDay
	 *            应该减去的工作日数量
	 * @return 当前时间减去指定工作日之后的时间
	 */
	public static Date getCurrentDateBeforeFewWorkDay(Integer workDay) {
		Date date = null;
		if (null != workDay) {
			DateTime now = DateTime.now();
			int period = workDay.intValue();
			for (int i = 0; i < period; i++) {
				now = now.minusDays(1);
				if (now.getDayOfWeek() == DateTimeConstants.SATURDAY || now.getDayOfWeek() == DateTimeConstants.SUNDAY) {
					i--;
				}
			}
			date = now.withTime(0, 0, 0, 0).toDate();
		}
		return date;
	}

	/**
	 * 获取当前时间加上指定工作日之后的时间
	 *
	 * @param workDay
	 *            应该加上的工作日数量
	 * @return 当前时间加上指定工作日之后的时间
	 */
	public static Date getCurrentDateAfterFewWorkDay(Date time, Integer workDay) {
		Date date = null;
		if (null != workDay) {
			DateTime now = DateTime.now();
			int period = workDay.intValue();
			for (int i = 0; i < period; i++) {
				now = now.plusDays(1);
				if (now.getDayOfWeek() == DateTimeConstants.SATURDAY || now.getDayOfWeek() == DateTimeConstants.SUNDAY) {
					i--;
				}
			}
			date = now.withTime(0, 0, 0, 0).toDate();
		}
		return date;
	}
	

	public static boolean isSameDate(Date date1, Date date2) {
       Calendar cal1 = Calendar.getInstance();
       cal1.setTime(date1);

       Calendar cal2 = Calendar.getInstance();
       cal2.setTime(date2);

       boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
               .get(Calendar.YEAR);
       boolean isSameMonth = isSameYear
               && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
       boolean isSameDate = isSameMonth
               && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                       .get(Calendar.DAY_OF_MONTH);

       return isSameDate;
   }

    /**
     * @author Cobain
     * @category 字符串处理工具类
     * @version 2016-09-28 初始化
     */
    public static final class StringUtils extends org.apache.commons.lang3.StringUtils {
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
}
