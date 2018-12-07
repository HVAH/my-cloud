package com.mall.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/4/7 10:44
 * @Version 1.0
 */
public class DownLoadUtils {
	public static final String TYPE_JPG = ".jpg";
	public static final String TYPE_JPEG = ".jpeg";
    public static final String TYPE_GIF = ".gif";
    public static final String TYPE_PNG = ".png";
    public static final String TYPE_BMP = ".bmp";
	/**
	 * 根据url下载文件
	 * @param
	 */
	public static  byte[] fileDownFromOss(String urlPath) {
		try {
			return urlGetPic(urlPath);
		}catch (Exception e) {
			//判断时候有后缀pan
			if(!urlPath.endsWith(TYPE_JPG) &&!urlPath.endsWith(TYPE_JPEG) && !urlPath.endsWith(TYPE_GIF)&&!urlPath.endsWith(TYPE_PNG)&&!urlPath.endsWith(TYPE_BMP)){
				urlPath=new StringBuffer().append(urlPath).append(TYPE_JPG).toString();
			}
			try {
				return urlGetPic(urlPath);
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 获取图片
	 * @param urlPath
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static byte[] urlGetPic(String urlPath) throws MalformedURLException, IOException {
		//构建url地址
		URL url=new URL(urlPath);
		//构建http连接
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
		//设置超时间为3秒
		 conn.setConnectTimeout(3*1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		//得到输入流
		InputStream inputStream = conn.getInputStream(); 
		//读取文件
		byte[] bytes =new byte[1024];
		int len=0;
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		while((len = inputStream.read(bytes)) != -1){
			outputStream.write(bytes, 0, len);
		}
		outputStream.close();
		//返回byte数组
		return outputStream.toByteArray();
	}
}
