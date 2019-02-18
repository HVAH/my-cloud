package com.mall.pay.confg;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Description 微信支付配置
 * @Author HuangJiang
 * @Date 2018/9/10 12:08
 * @Version 1.0
 */
@Configuration
public class MyWxpayConfig implements WXPayConfig {

	@Value("${wxpay.gate.way}")
	private String appId;

	@Value("${wxpay.mch.id}")
	private String mchId;

	@Value("${wxpay.key}")
	private String key;
	// 证书
	private byte[] certData;

	public MyWxpayConfig() {

	}

	@Override
	public String getMchID() {
		return mchId;
	}

	@Override
	public String getAppID() {
		return appId;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		return 5000;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		return 10000;
	}

	@Bean
	public WXPay wxPay() {
		return new WXPay(this);
	}
}
