package com.rabbitmq.send.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/9/21 9:15 下午
 */
@Component
public class TestSend {
	@Autowired
	RabbitTemplate rabbitTemplate;

	public void testSend() {
		//至于为什么调用这个API 后面会解释
		//参数介绍： 交换机名字，路由建， 消息内容
		rabbitTemplate.convertAndSend("directExchange", "direct.key", "hello");
	}
}
