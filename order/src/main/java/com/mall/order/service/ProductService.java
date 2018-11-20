package com.mall.order.service;

import com.mall.order.domain.SkusCache;

import java.util.List;

/**
 * @Description 订单service
 * @Author HuangJiang
 * @Date 2018/8/7 10:58
 * @Version 1.0
 **/
public interface ProductService {

    /**
     * 生产微信推广二维码
     * @param skus
     * @param picId
     * @return
     */
    String createTempOrder(List<Long> skus, String picId) throws Exception;

    /**
     * 获取sku清单信息
     * @param sceneId
     * @return
     */
    SkusCache getOrderConfirmOrderInfo(String sceneId) throws Exception;
}
