package com.mall.pay.controller;

import com.mall.base.utils.RespFactory;
import com.mall.base.utils.StopWatch;
import com.mall.base.utils.lock.RedisLock;
import com.mall.base.utils.lock.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/14 10:04
 * @Version 1.0
 **/
@RestController
@Slf4j
public class RedisLockController {

    private @Autowired
    RedisLockUtil redisLockUtil;
    private Integer coutn = 0;
    private Long time = 0L;


    @GetMapping("/redis")
    public ResponseEntity add(
        ) throws Exception {

        String [] keyStr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            keys.add(keyStr[i % 10]);
        }
        for (String key : keys) {
            new Thread(() -> {
                lock(key);
            }).start();
        }

        Thread.sleep(20000);

        return RespFactory.noContent(HttpStatus.OK);
    }

    public void lock(String key) {
        RedisLock lock = redisLockUtil.getLock(key);
        long start = System.currentTimeMillis();
        if (lock.lock()) {
            long end = System.currentTimeMillis();
            log.info(Thread.currentThread().getName() + "获取到 " + key + " 的锁 " + "获取锁时间为：" + (end - start));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            log.info(Thread.currentThread().getName() + "执行完毕");
            coutn++;
        }
    }
}
