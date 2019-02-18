package com.mall.study.service;

import com.mall.base.utils.StopWatch;
import com.mall.study.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/5 16:59
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderService {

	private @Resource ExecutorService executorService;

	public Integer submitOrder(Order order) {
		executorService.execute(new Runnable() {
                @Override
                public void run() {
	                System.out.println(Thread.currentThread().getName() + " " + order.getGoodsName());
	                try {
	                	// 模拟处理需要50秒
		                Thread.sleep(50);
	                } catch (InterruptedException e) {
		                e.printStackTrace();
	                }
                }
            }
		);
		return 10;
	}
}
