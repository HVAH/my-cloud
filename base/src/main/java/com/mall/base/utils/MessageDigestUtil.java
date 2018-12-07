package com.mall.base.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ken on 7/18/2018.
 */
public final class MessageDigestUtil {
    private MessageDigestUtil() {
    }

    /**
     * 使用指定哈希算法计算摘要信息
     *
     * @param algorithm 哈希算法
     * @param content   内容
     * @return 内容摘要
     */
    public static String getDigest(String algorithm, String content) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(content.getBytes("utf-8"));
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignore) {
        }
        return null;
    }

    /**
     * 将字节数组转换成16进制字符串
     *
     * @param bytes 即将转换的数据
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String temp = null;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(0xFF & aByte);
            if (temp.length() < 2) {
                sb.append(0);
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
