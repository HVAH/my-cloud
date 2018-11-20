package com.mall.order.domain;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/8/7 12:06
 * @Version 1.0
 **/
public class GoodsInfoVO {
    // sku信息
    private GoodsSku sku;
    // 商品信息
    private GoodsInfo goodsInfo;
    // 购买数量
    private int goodsCount;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public GoodsSku getSku() {
        return sku;
    }

    public void setSku(GoodsSku sku) {
        this.sku = sku;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}
