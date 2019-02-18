package com.mall.study.controller;

import com.mall.base.utils.StopWatch;
import com.mall.study.domain.Order;
import com.mall.study.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/5 16:55
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderTestController {

	private @Resource OrderService orderService;

	int i = 1;

	@PostMapping("/submit")
	public ResponseEntity method() {
		Random random =new Random();

			Order order = new Order(random.nextDouble() * 1000, "第 " + i++ + " 个订单");
			// 执行时间
			Integer executeTime = orderService.submitOrder(order);
	    return ResponseEntity.ok().body("ok");
	}


	@PostMapping("/start")
	public ResponseEntity start()throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0; i < 10000; i++) {
			method();
		}
		stopWatch.stop();
		log.info("================= " + stopWatch.getElapsedTime());
		return ResponseEntity.ok().body(stopWatch.getElapsedTime());
	}
}
