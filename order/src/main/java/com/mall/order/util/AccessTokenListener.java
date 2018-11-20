package com.mall.order.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by Junhe on 2018/8/3.
 * 定时获取access_token
 */
@Lazy(false)
@Component("accessTokenListener")
public class AccessTokenListener {
    public static String access_token = null;
    @Value("${thirdparty.weixin.appid}")
    private String appId;
    @Value("${thirdparty.weixin.secret}")
    private String appSecret;

    @Scheduled(fixedRate = 1000 * 7 * 1000)
    public void getAccessToken() {
        if(!"".equals(appId) &&! "".equals(appSecret)){
            access_token = new WechatApi().GetAccess_token(appId, appSecret);
        }

    }
}
