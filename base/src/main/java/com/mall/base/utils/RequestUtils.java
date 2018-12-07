package com.mall.base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.mall.base.utils.support.ip2region.DataBlock;
import com.mall.base.utils.support.ip2region.DbConfig;
import com.mall.base.utils.support.ip2region.DbSearcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.request.WebRequest;


public class RequestUtils {
	/**
	 * 获取真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ipAddress = null;
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	public static String getAgent(HttpServletRequest request) {
		String loginAgent = request.getHeader("User-Agent");
		if (StringUtils.contains(loginAgent, "IE")) {
			loginAgent = "IE 浏览器";
		} else if (StringUtils.contains(loginAgent, "Chrome")) {
			loginAgent = "Chrome 浏览器";
		} else if (StringUtils.contains(loginAgent, "Firefox")) {
			loginAgent = "Firefox 浏览器";
		} else if (StringUtils.contains(loginAgent, "360")) {
			loginAgent = "360 浏览器";
		} else if (StringUtils.contains(loginAgent, "iPhone")) {
			loginAgent = "iPhone";
		} else if (StringUtils.contains(loginAgent, "iPad")) {
			loginAgent = "iPad";
		} else if (StringUtils.contains(loginAgent, "Android")) {
			loginAgent = "Android手机";
		} else if (StringUtils.contains(loginAgent, "MicroMessenger")) {
			loginAgent = "微信";
		} else if (StringUtils.contains(loginAgent, "AlipayClient")) {
			loginAgent = "支付宝";
		} else {
			loginAgent = "其它浏览器";
		}
		return loginAgent;
	}

	private static DbSearcher dbSearcher = null;

	/**
	 * ip地址转网络地址
	 * 
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public static String getIpAddress(String ip, Class<?> clazz) throws Exception {
		if (dbSearcher == null) {
			DbConfig dbConfig = new DbConfig();
			if (clazz == null) {
				clazz = DbSearcher.class;
			}
			dbSearcher = new DbSearcher(dbConfig, new ClassPathResource("ip2region.db", clazz.getClassLoader()).getFile());
		}
		DataBlock dataBlock = dbSearcher.btreeSearch(ip);
		if (dataBlock != null) {
			if (clazz == null) {
				clazz = DbSearcher.class;
			}
			return dataBlock.getRegion().replace("|", "");
		}
		return StringUtils.EMPTY;
	}

	public static String getIpCity(String ip, Class<?> clazz) throws Exception {
		if (dbSearcher == null) {
			DbConfig dbConfig = new DbConfig();
			dbSearcher = new DbSearcher(dbConfig, new ClassPathResource("ip2region.db", clazz.getClassLoader()).getFile());
		}
		DataBlock dataBlock = dbSearcher.btreeSearch(ip);
		if (dataBlock != null) {

			return StringUtils.split(dataBlock.getRegion(), "\\|")[3];
		}
		return StringUtils.EMPTY;
	}
	
	/**
	 * 通过IP地址获取MAC地址
	 * 
	 * @param ip
	 *            String,127.0.0.1格式
	 * @return mac String
	 * @throws Exception
	 */
	public static String getMACAddress(String ip) throws Exception {
		String line = "";
		String macAddress = "";
		final String MAC_ADDRESS_PREFIX = "MAC Address = ";
		final String LOOPBACK_ADDRESS = "127.0.0.1";
		// 如果为127.0.0.1,则获取本地MAC地址。
		if (LOOPBACK_ADDRESS.equals(ip)) {
			InetAddress inetAddress = InetAddress.getLocalHost();
			// 貌似此方法需要JDK1.6。
			byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
			// 下面代码是把mac地址拼装成String
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				if (i != 0) {
					sb.append("-");
				}
				// mac[i] & 0xFF 是为了把byte转化为正整数
				String s = Integer.toHexString(mac[i] & 0xFF);
				sb.append(s.length() == 1 ? 0 + s : s);
			}
			// 把字符串所有小写字母改为大写成为正规的mac地址并返回
			macAddress = sb.toString().trim().toUpperCase();
			return macAddress;
		}
		// 获取非本地IP的MAC地址
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line != null) {
					int index = line.indexOf(MAC_ADDRESS_PREFIX);
					if (index != -1) {
						macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}

	// ======================================================================================================
	public static String getParameter(HttpServletRequest request, String parameter, String defVal) {
		String val = request.getParameter(parameter);
		return StringUtils.isBlank(val) ? defVal : StringUtils.trim(val);
	}

	public static Integer getInteger(HttpServletRequest request, String parameter, Integer defVal) {
		return NumberUtils.toInt(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static Double getDouble(HttpServletRequest request, String parameter, Double defVal) {
		return NumberUtils.toDouble(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static Date getDate(HttpServletRequest request, String parameter, Date defVal) {
		return DateFormatUtils.parse(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static String getParameter(HttpServletRequest request, String parameter) {
		return getParameter(request, parameter, StringUtils.EMPTY);
	}

	public static Integer getInteger(HttpServletRequest request, String parameter) {
		return getInteger(request, parameter, 0);
	}

	public static Double getDouble(HttpServletRequest request, String parameter) {
		return getDouble(request, parameter, 0d);
	}

	public static Date getDate(HttpServletRequest request, String parameter) {
		return getDate(request, parameter, null);
	}

	// ======================================================================================================
	public static String getParameter(WebRequest request, String parameter, String defVal) {
		String val = request.getParameter(parameter);
		return StringUtils.isBlank(val) ? defVal : StringUtils.trim(val);
	}

	public static Integer getInteger(WebRequest request, String parameter, Integer defVal) {
		return NumberUtils.toInt(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static Double getDouble(WebRequest request, String parameter, Double defVal) {
		return NumberUtils.toDouble(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static Date getDate(WebRequest request, String parameter, Date defVal) {
		return DateFormatUtils.parse(getParameter(request, parameter, StringUtils.EMPTY), defVal);
	}

	public static String getParameter(WebRequest request, String parameter) {
		return getParameter(request, parameter, StringUtils.EMPTY);
	}

	public static Integer getInteger(WebRequest request, String parameter) {
		return getInteger(request, parameter, 0);
	}

	public static Double getDouble(WebRequest request, String parameter) {
		return getDouble(request, parameter, 0d);
	}

	public static Date getDate(WebRequest request, String parameter) {
		return getDate(request, parameter, null);
	}
}
