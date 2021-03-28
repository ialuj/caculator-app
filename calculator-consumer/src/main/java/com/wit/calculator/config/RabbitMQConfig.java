package com.wit.calculator.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${calculator.rabbitmq.exchange}")
	String exchange;

	@Value("${calculator.rabbitmq.routingkey}")
	private String routingkey;
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${spring.rabbitmq.VirtualHost}")
	private String virtualHost;
	
	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
	    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	    connectionFactory.setHost(host);
	    connectionFactory.setVirtualHost(virtualHost);
	    connectionFactory.setUsername(username);
	    connectionFactory.setPassword(password);
	    return connectionFactory;
	}

}
