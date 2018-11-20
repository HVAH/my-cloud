package com.mall.pay.service;

/**
 * @Description 支付 service
 * @Author HuangJiang
 * @Date 2018/9/6 11:16
 * @Version 1.0
 */
public interface PayService {
	/**
	 * 统一获取支付信息
	 * @param orderNo
	 * @param orderType
	 * @param payment
	 * @param payComp
	 * @return
	 */
	String pay(Long orderNo, Integer orderType, Integer payment, Integer payComp);

	/**
	 * 主动查询支付结果
	 * @param orderNo
	 * @return
	 */
    String query(String orderNo, Integer payComp);

	/**
	 * 申请退款
	 * @param orderNo
	 * @return
	 */
	String refund(Long orderNo);

	/**
	 * 退款查询
	 * @param orderNo
	 * @return
	 */
	String refundQuery(String orderNo);
}
