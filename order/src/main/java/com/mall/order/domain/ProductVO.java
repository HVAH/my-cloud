package com.mall.order.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/9 18:14
 * @Version 1.0
 **/
public class ProductVO {
        private List<GoodsInfoVO> skus = new ArrayList<>();
        private String picId;

    public List<GoodsInfoVO> getSkus() {
        return skus;
    }

    public ProductVO() {
    }

    public ProductVO(List<GoodsInfoVO> skus, String picId) {

        this.skus = skus;
        this.picId = picId;
    }

    public void setSkus(List<GoodsInfoVO> skus) {
        this.skus = skus;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
}
