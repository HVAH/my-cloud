package com.mall.order.configurer;

import com.foxinmy.weixin4j.cache.RedisCacheStorager;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.token.WeixinTokenCreator;
import com.foxinmy.weixin4j.token.TicketManager;
import com.foxinmy.weixin4j.token.TokenManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/9 11:26
 * @Version 1.0
 **/
@Configuration
public class WeiXin4jConfigurer {
    private @Value("${thirdparty.weixin.appid}") String appid;
    private @Value("${thirdparty.weixin.secret}") String secret;
    private @Value("${spring.redis.host}") String redisHost;
    private @Value("${spring.redis.password}") String redisPassword;

    @Bean
    public WeixinProxy weixinProxy() {
        WeixinAccount weixinAccount = new WeixinAccount(appid, secret);
        WeixinProxy weixinProxy = new WeixinProxy(weixinAccount, redisCacheStorager());
        return  weixinProxy;
    }

    @Bean
    public WeixinTokenCreator weixinTokenCreator() {
        return new WeixinTokenCreator(appid, secret);
    }

    @Bean
    public TokenManager tokenManager() {
        return new TokenManager(weixinTokenCreator(), redisCacheStorager());
    }

    @Bean
    public TicketManager ticketManager() {
        return new TicketManager(appid, secret, redisCacheStorager());
    }

    private RedisCacheStorager redisCacheStorager() {
        return new RedisCacheStorager(redisHost, 6379, 3000, redisPassword);
    }
}
