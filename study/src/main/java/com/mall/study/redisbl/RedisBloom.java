package com.mall.study.redisbl;

/**
 * @Description lock 布隆过滤器 原理: 1 个m位 bit数组  n个hash函数,
 * 1 添加 将要过滤的string 分别用这 n个hash函数算出hash值,再用hash值分别对m取模, 将bit数组对应的位置设为1,
 * 2 查询 重复上面取模的操作,查看数组对应位的值, 如果都为1 表示大概率存在, 如果有且至少有一个为0, 则一定不存在
 * @Author Jiang
 * @Date 2018/12/7 11:22
 * @Version 1.0
 **/
public class RedisBloom {
    

}
