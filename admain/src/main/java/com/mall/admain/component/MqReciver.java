package com.mall.admain.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/24 12:07
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "${mq.quene}")
public class MqReciver {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqReciver.class);

	private @Resource AmqpTemplate rabbitTemplate;

	@RabbitHandler
	public void receive(String message) {
		LOGGER.info("[message: {}]", message);
		System.out.println(message);
	}
}
