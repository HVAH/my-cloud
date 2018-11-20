package com.mall.study.domain;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/5 17:02
 * @Version 1.0
 */
public class Order {
	private Double price;
	private String goodsName;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Order() {
	}

	public Order(Double price, String goodsName) {
		this.price = price;
		this.goodsName = goodsName;
	}
}
