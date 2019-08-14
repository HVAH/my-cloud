package com.mall.base.utils.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description redis分布式锁工具类
 * @Author Jiang
 * @Date 2019/8/13 11:09
 * @Version 1.0
 **/
@Component
public class RedisLockUtil {
    private @Autowired StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "REDIS_LOCK_%s";

    public RedisLock getLock(String lockKey) {
        return new RedisLock(appendKey(lockKey), redisTemplate);
    }
    public RedisLock getLock(String lockKey, int timeoutMS) {
        return new RedisLock(appendKey(lockKey), timeoutMS, redisTemplate);
    }
    public RedisLock getLock(String lockKey, int expireMS, int timeoutMS) {
        return new RedisLock(appendKey(lockKey), expireMS, timeoutMS, redisTemplate);
    }

    public StringRedisTemplate getRedisTemplate() {
        return this.redisTemplate;
    }
    public String appendKey(String lockKey) {
        return String.format(KEY_PREFIX, lockKey);
    }
}
