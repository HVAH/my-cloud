package com.mall.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static final Logger log = LoggerFactory.getLogger(MD5Util.class);

    private static char[] Digit = { '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f' };

    public static String getMd5Sum(String inputStr) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] inputStrByte = inputStr.getBytes();
        digest.update(inputStrByte, 0, inputStrByte.length);


        byte[] md5sum = digest.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16;i++) {
            char [] ob = new char[2];
            ob[0] = Digit[md5sum[i] >> 4 & 0x0F];
            ob[1] = Digit[md5sum[i] & 0x0F];
            String s = new String(ob);
            sb.append(s);
        }

        return sb.toString();
        //	BigInteger bigInt = new BigInteger(1, md5sum);
        //	String output = bigInt.toString(16);
        //	return output;
    }


    /**
     * 对字符串进行 MD5 加密
     *
     * @param str 待加密字符串
     *
     * @return 加密后字符串
     */
    public static String md5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            log.error("", e);
            throw new RuntimeException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        byte[] encodedValue = md5.digest();
        int j = encodedValue.length;
        char finalValue[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte encoded = encodedValue[i];
            finalValue[k++] = Digit[encoded >> 4 & 0xf];
            finalValue[k++] = Digit[encoded & 0xf];
        }

        return new String(finalValue).toUpperCase();
    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @return 签名结果
     */
    public static boolean verify(String text, String sign) {
        String mysign = md5(text);
        log.info("[加密过后的签名是：{}]",mysign);
        String lowerCaseSign = mysign.toLowerCase();
        log.info("[转换大小写后是：{}]",lowerCaseSign);
        if(lowerCaseSign.equals(sign)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 对文件进行 MD5 加密
     *
     * @param file 待加密的文件
     *
     * @return 文件加密后的 MD5 值
     * @throws IOException
     */
    public static String md5(File file) throws IOException {
        FileInputStream is = new FileInputStream(file);
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            int n = 0;
            byte[] buffer = new byte[1024];
            do {
                n = is.read(buffer);
                if (n > 0) {
                    md5.update(buffer, 0, n);
                }
            } while (n != -1);
            is.skip(0);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            is.close();
        }

        byte[] encodedValue = md5.digest();

        int j = encodedValue.length;
        char finalValue[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte encoded = encodedValue[i];
            finalValue[k++] = Digit[encoded >> 4 & 0xf];
            finalValue[k++] = Digit[encoded & 0xf];
        }

        return new String(finalValue).toUpperCase();
    }

    public static void main(String... args) {
        System.out.println(md5("123456a"));
    }

}
