package com.mall.pay.service;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/1/24 11:54
 * @Version 1.0
 **/
public interface OrderService {
    Boolean orderIsPaid(Long orderId, Integer orderType);
}
