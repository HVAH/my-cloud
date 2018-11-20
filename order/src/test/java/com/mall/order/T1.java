package com.mall.order;

import com.mall.order.util.RedisUtil;
import com.mall.order.util.SnowflakeIdWorker;
import com.mall.order.domain.GoodsInfo;
import com.mall.order.domain.GoodsSku;
import com.mall.order.repository.GoodsInfoMapper;
import com.mall.order.repository.GoodsSkuMapper;
import com.mall.order.repository.OrderDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/7 9:53
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class T1 {
    private @Resource RedisUtil redisUtil;
    private @Resource OrderDetailMapper orderDetailMapper;
    private @Resource GoodsInfoMapper goodsInfoMapper;
    private @Resource GoodsSkuMapper goodsSkuMapper;
    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(20, 20);
    public static void main(String[]args){

        for (int i = 0; i < 10; i++) {
            System.out.println(snowflakeIdWorker.nextId());
        }
    }

    @Test
    public void test() {
        Random  random = new Random();
        List<GoodsInfo> goodsInfos = goodsInfoMapper.select(new GoodsInfo());
        for (GoodsInfo goodsInfo : goodsInfos) {
            for (int i = 1; i < 4; i++) {
                GoodsSku goodsSku = new GoodsSku();
                goodsSku.setPkId(snowflakeIdWorker.nextId());
                goodsSku.setGoodsId(goodsInfo.getId());
                goodsSku.setSpecName(goodsInfo.getName() + "规格" + i);
                goodsSku.setSpecValue(goodsInfo.getName() + "规格值" + i);
                goodsSku.setSpecNo(random.nextInt(1000000));
                goodsSku.setSpecNum(100);
                goodsSku.setSpecPrice(new BigDecimal(random.nextDouble() * 1000));
                goodsSkuMapper.insert(goodsSku);
            }
        }
    }
}
