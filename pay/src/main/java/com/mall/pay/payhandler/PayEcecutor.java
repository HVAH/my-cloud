package com.mall.pay.payhandler;

import com.mall.pay.domain.PayInfo;
import com.mall.pay.domain.RefundInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/7 11:13
 * @Version 1.0
 */
@Component
public class PayEcecutor {

	private @Resource AlipayHandler alipayHandler;
	private @Resource WxpayHandler wxpayHandler;

	/**
	 * 发起支付
	 * @param payInfo
	 * @param payCom
	 * @param payType
	 * @return
	 */
	public String executePay(PayInfo payInfo, Integer payCom, Integer payType) {
		PayHandler payHandle = getPayHandle(payCom);
		switch (payType) {
			case 1:
				return payHandle.qrCodePay(payInfo);
			case 2:
				return payHandle.appPay(payInfo);
			default:
				throw new RuntimeException("no support payMent");
		}
	}

	/**
	 * 发起支付结果查询
	 * @param orderNo
	 * @param payComp
	 * @return
	 */
	public String executePayQuery(String orderNo, Integer payComp) {
		return getPayHandle(payComp).payQuery(orderNo);
	}

	/**
	 * 发起退款
	 * @param refundInfo
	 * @param payComp
	 * @return
	 */
	public String executeReFund(RefundInfo refundInfo, Integer payComp) {
		return getPayHandle(payComp).refund(refundInfo);
	}

	/**
	 * 发起退款查询
	 * @param orderNo
	 * @param refundNo
	 * @param payComp
	 */
	public String executeRefundQuery(String orderNo, String refundNo, Integer payComp) {
		return getPayHandle(payComp).refundQuery(orderNo, refundNo);
	}

	/**
	 * 获取支付处理器
	 * @param payCompay
	 * @return
	 */
	private PayHandler getPayHandle(Integer payCompay) {
		switch (payCompay) {
			case 1:
				return alipayHandler;
			case 2:
				return wxpayHandler;
			default:
				throw new RuntimeException("no such pay company");
		}
	}
}
