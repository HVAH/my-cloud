package com.mall.base.utils.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Description redis实现的分布式锁(改进版)，基于单机redis
 * @Author Jiang
 * @Date 2019/7/13 11:03
 * @Version 1.0
 **/
@Slf4j
public class RedisLock {
    // 锁的键值
    private String lockKey;
    // 锁超时, 防止线程得到锁之后, 不去释放锁
    private int expireMsecs = 15 * 1000;
    // 锁等待, 防止线程饥饿
    private int timeoutMsecs = 15 * 1000;
    // 是否已经获取锁
    private boolean locked = false;
    private StringRedisTemplate redisTemplate;
    // 自旋等待时间
    private int sleepWaitTime = 2;

    RedisLock(String lockKey, StringRedisTemplate redisTemplate) {
        this.lockKey = lockKey;
        this.redisTemplate = redisTemplate;
    }

    RedisLock(String lockKey, int timeoutMsecs, StringRedisTemplate redisTemplate) {
        if (timeoutMsecs > 0) {
            this.timeoutMsecs = timeoutMsecs;
        }
        this.lockKey = lockKey;
        this.redisTemplate = redisTemplate;
    }

    RedisLock(String lockKey, int expireMsecs, int timeoutMsecs, StringRedisTemplate redisTemplate) {
        this.lockKey = lockKey;
        if (expireMsecs > 0) {
            this.expireMsecs = expireMsecs;
        }
        if (timeoutMsecs > 0) {
            this.timeoutMsecs = timeoutMsecs;
        }
        this.redisTemplate = redisTemplate;
    }

    public String getLockKey() {
        return this.lockKey;
    }

    public synchronized boolean lock() {
        int timeout = timeoutMsecs;
        try {
            while (timeout >= 0) {
                // 锁到期时间
                String expiresStr = String.valueOf(System.currentTimeMillis() + expireMsecs + 1);
                if (redisTemplate.opsForValue().setIfAbsent(lockKey, expiresStr)) {
                    locked = true;
                    log.info("[1] 成功获取分布式锁!");
                    return true;
                }
                // 获取key的到期时间
                String currentValueStr = redisTemplate.opsForValue().get(lockKey);
                // 判断是否为空, 不为空的情况下, 如果被其他线程设置了值, 则第二个条件判断是过不去的
                if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                    String oldValueStr = redisTemplate.opsForValue().getAndSet(lockKey, expiresStr);
                    // 获取上一个锁到期时间, 并设置现在的锁到期时间
                    // 只有一个线程才能获取上一个线程的设置时间
                    // 如果这个时候, 多个线程恰好都到了这里, 但是只有一个线程的设置值和当前值相同, 它才有权利获取锁
                    if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                        locked = true;
                        log.info("[2] 成功获取分布式锁!");
                        return true;
                    }
                }
                timeout -= sleepWaitTime;
                try {
                    Thread.sleep(sleepWaitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            log.error("获取锁出现异常, 必须释放: {}", e.getMessage());
        }
        return false;
    }

    public synchronized void unlock() {
        try {
            if (locked) {
                // redis里的时间
                String currentValueStr = redisTemplate.opsForValue().get(lockKey);
                // 校验是否超过有效期, 如果不在有效期内, 那说明当前锁已经失效, 不能进行删除锁操作
                if (currentValueStr != null && Long.parseLong(currentValueStr) > System.currentTimeMillis()) {
                    redisTemplate.delete(lockKey);
                    locked = false;
                    log.info("[3] 成功释放分布式锁!");
                }
            }
        } catch (Exception e) {
            log.error("释放锁出现异常, 必须释放: {}", e.getMessage());
        }
    }
}

