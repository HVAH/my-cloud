package com.mall.study.study.other;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class T1 {
 public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
	list.stream();
	System.out.println('f');

	Class clazz = int.class;
 }
 
 public static String getLocation(double longitude, double latitude) {
	 String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + latitude + "," + longitude + "&type=010";
	 String res = "";
	 URL url;
	 try {
		 url = new URL(urlString);
		 java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
		 conn.setDoOutput(true);
		 conn.setRequestMethod("POST");
		 java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
		 String line;
		 while ((line = in.readLine()) != null) {
			 res += line + "/n";
		 }
		 in.close();
	 } catch (IOException e) {
		 
		 e.printStackTrace();
	 }
	 return res;
 }
}
