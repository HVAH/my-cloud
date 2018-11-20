package com.mall.order.service.impl;

import com.mall.order.common.RedisConstans;
import com.mall.order.domain.*;
import com.mall.order.service.ProductService;
import com.mall.order.util.RedisUtil;
import com.mall.order.util.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description 商品service实现类
 * @Author HuangJiang
 * @Date 2018/8/7 11:03
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    private @Resource WechatApiService wechatApiService;
    private @Resource RedisUtil redisUtil;

    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(20, 20);

    @Override
    public String createTempOrder(List<Long> skus, String picId) throws Exception {
        Long sceneId = snowflakeIdWorker.nextId();
        // 生产二维码
        String qrCodeUrl = wechatApiService.getQrCodeUrl(sceneId, 60 * 60);
        SkusCache skusCache = new SkusCache(skus, picId);
        // 缓存清单
        redisUtil.set(RedisConstans.SKU_KEY + sceneId, skusCache, 60 * 60L);
        // 缓存qrcodekey
        String[] split = qrCodeUrl.split("/");
        redisUtil.set(RedisConstans.SKU_KEY + split[4], skusCache,  60 * 60L);
        return qrCodeUrl;
    }

    @Override
    public SkusCache getOrderConfirmOrderInfo(String sceneId) throws Exception {
        // 获取redis缓存的skus
        SkusCache skusCache = (SkusCache) redisUtil.get(RedisConstans.SKU_KEY + sceneId);
        return skusCache;
    }

}
