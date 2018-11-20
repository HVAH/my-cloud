package com.mall.study.study.other;
import java.util.concurrent.ConcurrentHashMap;

public class T5 {
	private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		new Thread("Thread1"){  
            @Override  
            public void run() {  
                map.put(3, 33);  
            }  
        };  
          
        new Thread("Thread2"){  
            @Override  
            public void run() {  
                map.put(4, 44);  
            }  
        };  
          
        new Thread("Thread3"){  
            @Override  
            public void run() {  
                map.put(7, 77);  
            }  
        };  
        System.out.println(map);  
		
	}
	
	
	
	public static String getEncoding(String str) {  
	    String encode[] = new String[]{  
	            "UTF-8",  
	            "ISO-8859-1",  
	            "GB2312",  
	            "GBK",  
	            "GB18030",  
	            "Big5",  
	            "Unicode",  
	            "ASCII"  
	    };  
	    for (int i = 0; i < encode.length; i++){  
	        try {  
	            if (str.equals(new String(str.getBytes(encode[i]), encode[i]))) {  
	                return encode[i];  
	            }  
	        } catch (Exception ex) {  
	        }  
	    }  
	      
	    return "";  
	}  
}
