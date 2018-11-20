package com.mall.pay.service.impl;

import com.mall.pay.domain.PayInfo;
import com.mall.pay.domain.RefundInfo;
import com.mall.pay.payhandler.PayEcecutor;
import com.mall.pay.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 支付service 实现类
 * @Author HuangJiang
 * @Date 2018/9/6 11:18
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {

	private final static Logger LOGGER = LoggerFactory.getLogger(PayServiceImpl.class);
	private @Resource PayEcecutor payEcecutor;


	@Override
	public String pay(Long orderNo, Integer orderType, Integer payment, Integer payComp) {
		// 检查订单是否已经支付
		if (orderPaid(orderNo, orderType)) {
			throw new RuntimeException("please dont double payment");
		}

		if (orderPaid(orderNo, orderType))
			throw new RuntimeException("order has paid");

		return payEcecutor.executePay(getOrderPayInfo(orderNo, orderType), payComp, payment);
	}

	@Override
	public String query(String orderNo, Integer payComp) {
		return payEcecutor.executePayQuery(orderNo, payComp);
	}

	@Override
	public String refund(Long orderNo) {
		// 查询到支付公司 TODO
		Integer payComp = 1;
		// 生成订单退款信息

		RefundInfo refundInfo = new RefundInfo();
		return payEcecutor.executeReFund(refundInfo, payComp);
	}

	@Override
	public String refundQuery(String orderNo) {
		// 查询到支付公司 TODO
		Integer payComp = 1;
		String refundNo = "";
		payEcecutor.executeRefundQuery(orderNo, refundNo,  payComp);
		return null;
	}

	/**
	 * 查询订单状态
	 * @param orderId
	 * @param orderType
	 * @return
	 */
	private boolean orderPaid(Long orderId, Integer orderType) {
		boolean result = false;
		// 查询订单状态 TODO

		return result;
	}

	/**
	 * 获取订单支付信息
	 * @param orderNo
	 * @param orderType
	 * @return
	 */
	private PayInfo getOrderPayInfo(Long orderNo, Integer orderType) {
		PayInfo payInfo = new PayInfo();
		payInfo.setAmount("99");
		payInfo.setOrderNo(orderNo.toString());
		return payInfo;
	}


}
