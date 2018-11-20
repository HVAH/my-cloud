package com.mall.admain;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/24 11:40
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class test {


	private @Resource AmqpTemplate rabbitTemplate;

	/**
	 * 测试
	 * @throws Exception
	 */
	@Test
	public void sendMessage() throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();


		rabbitTemplate.convertSendAndReceive("test", "fist message");



		stopWatch.stop();
		System.out.println("================耗时: " + stopWatch.getTime() + " ms");
	}
}
