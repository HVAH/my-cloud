package com.mall.order.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Junhe on 2018/8/3.
 */
public class AttestationUtil {
    private static Logger logger = LoggerFactory.getLogger(AttestationUtil.class);
    private static final String token = "vah";

    public static boolean checkSignature( String signature, String timestamp, String nonce) {
        logger.info("token:{}", token);
        String[] arr = new String[]{token, timestamp, nonce};
        //将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        //将三个参数字符串拼接成一个字符串进行sha1加密
        String sha_1 = DigestUtils.sha1Hex(stringBuilder.toString());
        //获得加密后的字符串可与signature对比，标识该请求来源于微信
        return stringBuilder != null ? signature.equals(sha_1) : false;
    }
}
