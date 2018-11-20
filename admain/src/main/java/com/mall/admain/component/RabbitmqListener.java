package com.mall.admain.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/24 16:15
 * @Version 1.0
 */
@Component
public class RabbitmqListener implements ChannelAwareMessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqListener.class);
	private @Resource ObjectMapper objectMapper;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {

	}
}
