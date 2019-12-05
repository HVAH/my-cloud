package com.vah.reptile.config;

import com.foxinmy.weixin4j.cache.RedisCacheStorager;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/8/9 11:26
 * @Version 1.0
 **/
@Configuration
public class WxProxyFactory {

    private @Value("${spring.redis.host}") String redisHost;
    private @Value("${spring.redis.port}") int redisPort;
    private @Value("${spring.redis.password:#{null}}") String redisPassword;
    private @Value("${spring.redis.database}") int redisDatabase;


    private Map<String, WeixinProxy> weixinProxyMap = new HashMap<>();
    private @Resource RedisCacheStorager redisCacheStorager;


    public WeixinProxy getProxy(String appId) {
        if (CollectionUtils.isEmpty(weixinProxyMap)) {
            initProxy();
        }
        return weixinProxyMap.get(appId);
    }


//    @Scheduled(cron = "0 0 0 * * ?")
    private void initProxy() {
            weixinProxyMap.put("wx9790544c70e9b2dd", new WeixinProxy(new WeixinAccount("wx9790544c70e9b2dd", "xiaifeifei123"), redisCacheStorager));
    }

    @Bean
    public RedisCacheStorager redisCacheStorager(
            @Value("${spring.redis.host}") String redisHost,
            @Value("${spring.redis.port}") int redisPort,
            @Value("${spring.redis.password:#{null}}") String redisPassword,
            @Value("${spring.redis.database}") int redisDatabase
    ) {
        return new ReptileRedisCacheStorage(redisHost, redisPort, redisPassword, redisDatabase, 3000);
    }

    private static class ReptileRedisCacheStorage extends RedisCacheStorager {
        private final static int MAX_TOTAL = 50;
        private final static int MAX_IDLE = 5;
        private final static int MAX_WAIT_MILLIS = 5000;
        private final static boolean TEST_ON_BORROW = false;
        private final static boolean TEST_ON_RETURN = true;
        private final static JedisPoolConfig POOLCONFIG;

        static {
            POOLCONFIG = new JedisPoolConfig();
            POOLCONFIG.setMaxTotal(MAX_TOTAL);
            POOLCONFIG.setMaxIdle(MAX_IDLE);
            POOLCONFIG.setMaxWaitMillis(MAX_WAIT_MILLIS);
            POOLCONFIG.setTestOnBorrow(TEST_ON_BORROW);
            POOLCONFIG.setTestOnReturn(TEST_ON_RETURN);
        }

        ReptileRedisCacheStorage(String host, int port, String password, int database, int timeout) {
            super(new JedisPool(POOLCONFIG, host, port, timeout, password, database, null));
        }
    }
}
