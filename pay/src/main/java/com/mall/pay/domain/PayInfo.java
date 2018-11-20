package com.mall.pay.domain;

import java.io.Serializable;
/**
 * @Description 支付信息
 * @Author HuangJiang
 * @Date 2018/9/12 16:35
 * @Version 1.0
 */
public class PayInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1876447324102809245L;

	private String amount;
	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
