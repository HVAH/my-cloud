package com.mall.pay.payhandler;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.mall.pay.confg.AlipayConfig;
import com.mall.pay.domain.PayInfo;
import com.mall.pay.domain.RefundInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Description 支付宝逻辑处理
 * @Author HuangJiang
 * @Date 2018/9/6 17:18
 * @Version 1.0
 */
@Component
public class AlipayHandler implements PayHandler{

	private AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATE_WAY,
			AlipayConfig.APP_ID, AlipayConfig.RSA_PRI_KEY, "json", "utf-8", AlipayConfig.ALI_PUB_KEY, "RSA2");

	private final static Logger LOGGER = LoggerFactory.getLogger(AlipayHandler.class);
	private final static String pay_notify_url = "";
	private final static String refund_notify_url = "";

	@Override
	public String qrCodePay(PayInfo payInfo) {
		// 设置参数
		AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
		model.setSubject("VAH商城订单");
		model.setTotalAmount(payInfo.getAmount());
		model.setOutTradeNo(payInfo.getOrderNo());
		model.setBody("VAH商城订单");
		AlipayTradePrecreateRequest precreateRequest = new AlipayTradePrecreateRequest();
		precreateRequest.setBizModel(model);
		precreateRequest.setNotifyUrl(pay_notify_url);
		String result = "";
		try {
			LOGGER.info("[发起支付宝支付|创建支付二维码|订单号: {}]", payInfo.getOrderNo());
			AlipayTradePrecreateResponse response = alipayClient.execute(precreateRequest);
			if (!response.isSuccess()) {
				LOGGER.info("[发起支付宝支付失败|创建支付二维码|订单号: {}|失败原因: {}]", payInfo.getOrderNo(), "code "
						+ response.getCode() + " msg " + response.getMsg() + " sub_code " + response.getSubCode()
						+ " sub_msg " + response.getSubMsg());
			}
			result = response.getQrCode();
		} catch (AlipayApiException e) {
			LOGGER.error(String.format("[发起支付宝支付异常|创建支付二维码|订单号: %s]", payInfo.getOrderNo()), e.getStackTrace());
		}
		return result;
	}

	@Override
	public String appPay(PayInfo payInfo) {
		// 设置参数
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setSubject("VAH商城订单");
		model.setTotalAmount(payInfo.getAmount());
		model.setOutTradeNo(payInfo.getOrderNo());
		model.setBody("VAH商城订单");
		AlipayTradeAppPayRequest appPayRequest = new AlipayTradeAppPayRequest();
		appPayRequest.setBizModel(model);
		appPayRequest.setNotifyUrl(pay_notify_url);
		String result = "";
		try {
			LOGGER.info("[发起支付宝支付|APP支付|订单号: {}]", payInfo.getOrderNo());
			// 获取客户端SDK支付的orderStr
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(appPayRequest);
			if (!response.isSuccess()) {
				LOGGER.info("[发起支付宝支付失败|app支付|订单号: {}|失败原因: {}]", payInfo.getOrderNo(), "code "
						+ response.getCode() + " msg " + response.getMsg() + " sub_code " + response.getSubCode()
						+ " sub_msg " + response.getSubMsg());
			}
			// 直接返回客户端SDK,无需处理
			result = response.getBody();
		} catch (AlipayApiException e) {
			LOGGER.error(String.format("[发起支付宝支付异常|APP支付|method: %s]", appPayRequest.getApiMethodName()), e.getStackTrace());
		}
		return result;
	}

	@Override
	public String payQuery(String orderNo) {
		AlipayTradeQueryModel model = new AlipayTradeQueryModel();
		model.setOutTradeNo(orderNo);
		AlipayTradeQueryRequest queryRequest = new AlipayTradeQueryRequest();
		queryRequest.setBizModel(model);

		String result = "";
		try {
			LOGGER.info("[发起支付宝支付结果查询|订单号: {}]", orderNo);
			AlipayTradeQueryResponse response = alipayClient.execute(queryRequest);
			if (!response.isSuccess()) {
				LOGGER.info("[发起支付宝支付结果查询失败|订单号: {}|失败原因: {}]", orderNo, "code "
						+ response.getCode() + " msg " + response.getMsg() + " sub_code " + response.getSubCode()
						+ " sub_msg " + response.getSubMsg());
			}
			result = response.getTradeStatus();
		} catch (AlipayApiException e) {
			LOGGER.error(String.format("[发起支付宝支付结果查询异常|订单号: %s]", orderNo), e.getStackTrace());
		}

		return result;
	}

	@Override
	public String refund(RefundInfo refundInfo) {
		AlipayTradeRefundModel model = new AlipayTradeRefundModel();
		model.setOutTradeNo(refundInfo.getOrderNo());
		model.setRefundAmount(refundInfo.getAmount());
		model.setOutRequestNo(refundInfo.getRefundNo());
		AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
		refundRequest.setBizModel(model);

		try {
			LOGGER.info("[发起支付宝支付退款|订单号: {}]", refundInfo.getOrderNo());
			AlipayTradeRefundResponse response = alipayClient.execute(refundRequest);
			if (!response.isSuccess()) {
				LOGGER.info("[发起支付宝退款失败|订单号: {}|失败原因: {}]", refundInfo.getOrderNo(), "code "
						+ response.getCode() + " msg " + response.getMsg() + " sub_code " + response.getSubCode()
						+ " sub_msg " + response.getSubMsg());
			}

		} catch (AlipayApiException e) {
			LOGGER.error(String.format("[发起支付宝退款异常|订单号: %s]", refundInfo.getOrderNo()), e.getStackTrace());
		}

		return null;
	}

	@Override
	public String refundQuery(String orderNo, String refundNo) {
		AlipayTradeFastpayRefundQueryModel modle = new AlipayTradeFastpayRefundQueryModel();
		modle.setOutRequestNo(refundNo);
		modle.setOutTradeNo(orderNo);
		AlipayTradeFastpayRefundQueryRequest refundQueryRequest = new AlipayTradeFastpayRefundQueryRequest();
		refundQueryRequest.setBizModel(modle);
		return null;
	}

	@Override
	public String accountStatement() {
		return null;
	}
}
