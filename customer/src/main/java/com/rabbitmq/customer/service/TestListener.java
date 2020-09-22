package com.rabbitmq.customer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/9/21 9:31 下午
 */
@Component
public class TestListener  {


	@RabbitListener(queues = "testQueue")
	public void get(String message) throws Exception{
		System.out.println(message);
	}

}
