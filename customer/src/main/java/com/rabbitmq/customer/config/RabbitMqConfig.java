package com.rabbitmq.customer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/9/21 9:05 下午
 */
@Configuration
public class RabbitMqConfig {
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost",5672);
		//我这里直接在构造方法传入了
		//        connectionFactory.setHost();
		//        connectionFactory.setPort();
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("my_vhost");
		//是否开启消息确认机制
		//connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}

	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange("directExchange");
	}

	@Bean
	public Queue queue() {
		//名字  是否持久化
		return new Queue("testQueue", true);
	}

	@Bean
	public Binding binding() {
		//绑定一个队列  to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
		return BindingBuilder.bind(queue()).to(defaultExchange()).with("direct.key");
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		//注意  这个ConnectionFactory 是使用javaconfig方式配置连接的时候才需要传入的  如果是yml配置的连接的话是不需要的
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		return template;
	}

}
