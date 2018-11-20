package com.mall.order.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/9 18:05
 * @Version 1.0
 **/
public class SkusCache {
    private List<Long> skus = new ArrayList<>();
    private String pic;

    public SkusCache() {
    }

    public SkusCache(List<Long> skus, String pic) {
        this.skus = skus;
        this.pic = pic;
    }

    public List<Long> getSkus() {
        return skus;
    }

    public void setSkus(List<Long> skus) {
        this.skus = skus;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
