package com.mall.pay.domain;

/**
 * @Description 退款信息
 * @Author HuangJiang
 * @Date 2018/9/12 16:35
 * @Version 1.0
 */
public class RefundInfo {
    // 退款单号
    private String refundNo;
    // 退款金额 单位 元
    private String amount;
    // 订单号
    private String orderNo;

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
