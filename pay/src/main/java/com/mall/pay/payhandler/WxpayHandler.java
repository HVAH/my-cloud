package com.mall.pay.payhandler;

import com.github.wxpay.sdk.WXPay;
import com.mall.base.utils.DateFormatUtils;
import com.mall.pay.domain.PayInfo;
import com.mall.pay.domain.RefundInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 微信支付逻辑处理
 * @Author HuangJiang
 * @Date 2018/9/6 17:19
 * @Version 1.0
 */
@Component
public class WxpayHandler implements PayHandler{

	private final static Logger LOGGER = LoggerFactory.getLogger(WxpayHandler.class);
	private final static String PAY_NOTIFY_URL = "";
	private final static String REFUND_NOTIFY_URL = "";
	private static String IP = "111.111.111.111";

	private @Resource WXPay wxPay;


	@Override
	public String qrCodePay(PayInfo payInfo) {
		Map<String, String> response = wxUniPay(payInfo, "NATIVE");
		return response.get("code_url");
	}

	@Override
	public String appPay(PayInfo payInfo) {
		Map<String, String> response = wxUniPay(payInfo, "APP");
		return response.get("prepay_id");
	}



	@Override
	public String payQuery(String orderNo) {
	    Map<String, String> params = new HashMap<>(2);
	    params.put("out_trade_no", orderNo);
        Map<String, String> response = new HashMap<>();
        try {
        	response = wxPay.orderQuery(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.get("");
	}

	@Override
	public String refund(RefundInfo refundInfo) {
		Map<String, String> params = new HashMap<>(8);
		params.put("nonce_str", DateFormatUtils.StringUtils.uuid());
		params.put("out_trade_no", refundInfo.getOrderNo());
		params.put("out_refund_no", refundInfo.getRefundNo());
		params.put("refund_fee", refundInfo.getAmount());
		params.put("refund_fee_type", "CNY");
		params.put("notify_url", REFUND_NOTIFY_URL);

		Map<String, String> response = new HashMap<>();
		try {
			LOGGER.info("[发起微信退款|退款单号: {}]", refundInfo.getRefundNo());
			response = wxPay.refund(params);
			if (!"SUCCESS".equals(response.get("return_code"))) {
				LOGGER.info("[发起微信退款|退款失败|失败原因: {}|参数: {}]", response.get("return_msg"), params.toString());
			}
			if (!"SUCCESS".equals(response.get("result_code"))) {
				LOGGER.info("[发起微信退款|退款失败|失败原因: {}|参数: {}]", response.get("err_code_des"), params.toString());
			}
		} catch (Exception e) {
			LOGGER.error(String.format("[发起微信退款出现异常||参数: %s]", params.toString()), e.getStackTrace());
		}
		return null;
	}

	@Override
	public String refundQuery(String orderNo, String refundNo) {
		Map<String, String> params = new HashMap<>(5);
		params.put("nonce_str", DateFormatUtils.StringUtils.uuid());
		params.put("out_refund_no", refundNo);

		Map<String, String> response = new HashMap<>();
		try {
			LOGGER.info("[发起微信退款查询|退款单号: {}]", refundNo);
			response = wxPay.refundQuery(params);
			if (!"SUCCESS".equals(response.get("return_code"))) {
				LOGGER.info("[发起微信退款查询|查询失败|失败原因: {}|参数: {}]", response.get("return_msg"), params.toString());
			}
			if (!"SUCCESS".equals(response.get("result_code"))) {
				LOGGER.info("[发起微信退款查询|查询失败|失败原因: {}|参数: {}]", response.get("err_code_des"), params.toString());
			}
		} catch (Exception e) {
			LOGGER.error(String.format("[发起微信退款查询出现异常||参数: %s]", params.toString()), e.getStackTrace());
		}
		return null;
	}

	@Override
	public String accountStatement() {
		return null;
	}

	/**
	 * 微信统一下单
	 * @param payInfo
	 * @param tradeType
	 * @return
	 */
	private Map<String, String> wxUniPay(PayInfo payInfo, String tradeType) {
		Map<String, String> params = new HashMap<>(10);
		// 描述
		params.put("body", "VAH商城订单");
		// 币种
		params.put("fee_type", "CNY");
		// ip
		params.put("spbill_create_ip", getIp());
		// 回调地址
		params.put("notify_url", PAY_NOTIFY_URL);
		//
        params.put("nonce_str", DateFormatUtils.StringUtils.uuid());
		// 支付类型 JSAPI 公众号支付 NATIVE 扫码支付 APP APP支付
		params.put("trade_type", tradeType);
		params.put("product_id", "12");
		params.put("total_fee", String.format("%.0f", Double.valueOf(payInfo.getAmount()) * 100));
		params.put("out_trade_no", payInfo.getOrderNo());
		Map<String, String> response = new HashMap<>();
		try {
			response = wxPay.unifiedOrder(params);
			LOGGER.info("[发起微信支付|支付方式: {}|参数: {}]", tradeType, params.toString());
		} catch (Exception e) {
			LOGGER.error(String.format("[发起微信支付出现异常|支付方式: %s|参数: %s]", tradeType, params.toString()), e.getStackTrace());
		}
		if (!"SUCCESS".equals(response.get("return_code"))) {
			LOGGER.info("[发起微信支付失败|支付方式: {}|失败原因: {}|参数: {}]", tradeType, response.get("return_msg"), params.toString());
		}
		if (!"SUCCESS".equals(response.get("result_code"))) {
			LOGGER.info("[发起微信支付失败|支付方式: {}|失败原因: {}|参数: {}]", tradeType, response.get("err_code_des"), params.toString());
		}
		return response;
	}

	public static String getIp(){
		try {
			if(IP==null||IP.isEmpty()){
				IP =InetAddress.getLocalHost().getHostAddress();
			}
		} finally {
			return IP;
		}
	}
}
