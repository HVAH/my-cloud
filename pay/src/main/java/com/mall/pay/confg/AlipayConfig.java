package com.mall.pay.confg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 支付宝配置
 * @Author HuangJiang
 * @Date 2018/9/6 11:34
 * @Version 1.0
 */
@Configuration
public class AlipayConfig {

	/** 支付宝网关 */
	public static String GATE_WAY = "";
	/** 支付宝appId */
	public static String APP_ID = "";
	/** 应用私钥 */
	public static String RSA_PRI_KEY = "";
	/** 应用公钥 */
	public static String PUB_KEY = "";
	/** 支付宝公钥 */
	public static String ALI_PUB_KEY = "";
	/** 签名方式 */
	public static String SIGN_TYPE = "RSA2";

	@Value("${alipay.gate.way}")
	public void setGateWay(String gateWay) {
		GATE_WAY = gateWay;
	}

	@Value("${alipay.app.id}")
	public void setAppId(String appId) {
		APP_ID = appId;
	}

	@Value("${alipay.rsa.pri.key}")
	public void setRsaPriKey(String rsaPriKey) {
		RSA_PRI_KEY = rsaPriKey;
	}

	@Value("${alipay.pub.key}")
	public void setPubKey(String pubKey) {
		PUB_KEY = pubKey;
	}

	@Value("${alipay.ali.pub.key}")
	public void setAliPubKey(String aliPubKey) {
		ALI_PUB_KEY = aliPubKey;
	}
}
