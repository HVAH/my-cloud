package com.mall.admain.config;

import com.mall.admain.component.RabbitmqListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/8/24 16:00
 * @Version 1.0
 */
@Configuration
public class RabbitmqConfig {

	private @Resource CachingConnectionFactory cachingConnectionFactory;
	private @Resource RabbitmqListener rabbitmqListener;

	private @Value("${mq.quene}") String queneName;
	private @Value("${mq.exchange}") String exchange;
	private @Value("${mq.routingKey}") String routingKey;

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(cachingConnectionFactory);
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(queneName, true, false);
	}

	@Bean
	public Queue queue() {
		return new Queue(exchange, true);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(directExchange()).with(routingKey);
	}

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConcurrentConsumers(1);
		container.setMaxConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //手动确认模式
		container.setQueues(queue());
		container.setMessageListener(rabbitmqListener);
		return container;
	}
}
