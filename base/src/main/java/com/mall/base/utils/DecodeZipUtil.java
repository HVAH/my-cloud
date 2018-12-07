package com.mall.base.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
/**
 * 解压缩工具类
 * @author liguang
 * 
 */
public class DecodeZipUtil {
	 private static final int buffer = 2048;  
	 private static final Logger logger = LoggerFactory.getLogger(DecodeZipUtil.class);
	/**
	 * 解文件压缩
	 * zipFilePath 压缩文件路径  afterZipFilePath 解压缩后文件存放位置 encryPassword 解压缩密码(如果文件是进行加密的需要传入)
	 */
	  public static void unZip(String path,String afterZipPath){  
		  int count = -1;
		  //
		  File file = null;  
		  InputStream is = null;  
		  FileOutputStream fos = null;  
		  BufferedOutputStream bos = null;  

		  afterZipPath = path.substring(0, path.lastIndexOf(".")) + File.separator; //保存解压文件目录  
		  new File(afterZipPath).mkdir(); //创建保存目录  
		  ZipFile zipFile = null;  
		  	try  
		  		{  
		  		zipFile = new ZipFile(path,"gbk"); //解决中文乱码问题  
		  		Enumeration<?> entries = zipFile.getEntries();  
		        while(entries.hasMoreElements()){  
                   byte buf[] = new byte[buffer];  
                   ZipEntry entry = (ZipEntry)entries.nextElement();  
                   String filename = entry.getName();  
                   boolean ismkdir = false;  
                   if(filename.lastIndexOf("/") != -1){ //检查此文件是否带有文件夹  
                	   ismkdir = true;  
                   }  
                   	   filename = afterZipPath + filename;  
                   if(entry.isDirectory()){ //如果是文件夹先创建  
                	   file = new File(filename);  
                	   file.mkdirs();  
                	   continue;  
                   }  
                   		file = new File(filename);  
                   if(!file.exists()){ //如果是目录先创建  
                	   if(ismkdir){  
                		   new File(filename.substring(0, filename.lastIndexOf("/"))).mkdirs(); //目录先创建  
                	  }  
                   }  
                   		file.createNewFile(); //创建文件  

                   is = zipFile.getInputStream(entry);  
                   fos = new FileOutputStream(file);  
                   bos = new BufferedOutputStream(fos, buffer);  

                   while((count = is.read(buf)) > -1){  
                	   bos.write(buf, 0, count);  
                   }  
                   	bos.flush();  
                   	bos.close();  
                   	fos.close();  
                   	is.close();  
		        }  

		        zipFile.close();  

		 }catch(IOException ioe){  
            ioe.printStackTrace();  
		 }finally{  
            try{  
            if(bos != null){  
                bos.close();  
            }  
            if(fos != null) {  
                fos.close();  
            }  
            if(is != null){  
                is.close();  
            }  
            if(zipFile != null){  
                zipFile.close();  
            }  
            }catch(Exception e) {  
                e.printStackTrace();  
            }  
        }  
		logger.info("[解压缩文件|解压成功]");
    } 
	  /**
	   * 测试
	   * @param args
	   */
	  public static void main(String[] args) {
		unZip("D:/test/5bc2e99e-f4e8-4607-9df4-20aff0302318.zip", "D:/test");
	}
}