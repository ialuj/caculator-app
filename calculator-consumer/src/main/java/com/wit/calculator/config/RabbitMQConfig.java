package com.wit.calculator.config;

import org.springframework.amqp.core.DirectExchange;
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

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
