package com.mall.pay.payhandler;

import com.mall.pay.domain.PayInfo;
import com.mall.pay.domain.RefundInfo;

/**
 * @Description 支付处理器
 * @Author HuangJiang
 * @Date 2018/9/6 17:22
 * @Version 1.0
 */
public interface PayHandler {

	/**
	 * 二维码支付
	 * @param payInfo
	 * @return
	 */
	String qrCodePay(PayInfo payInfo);

	/**
	 * app支付
	 * @param payInfo
	 * @return
	 */
	String appPay(PayInfo payInfo);

	/**
	 * 支付结果查询
	 * @param orderNo 订单号
	 * @return
	 */
	String payQuery(String orderNo);

	/**
	 * 申请退款
	 * @param refundInfo 退款信息
	 * @return
	 */
	String refund(RefundInfo refundInfo);

	/**
	 * 退款结果查询
	 * @param refundNo 退款单号
	 * @param no
	 * @return
	 */
	String refundQuery(String refundNo, String no);

	/**
	 * 下载对账单
	 * @return
	 */
	String accountStatement();
}
