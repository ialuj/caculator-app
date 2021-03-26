package com.wit.calculator.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wit.calculator.model.dto.OperandsDTO;

@Service
public class RabbitMQSender implements IRabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${calculator.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${calculator.rabbitmq.routingkey}")
	private String routingkey;	

	public OperandsDTO send(final OperandsDTO operandsDTO) {
		return (OperandsDTO) rabbitTemplate.convertSendAndReceive(exchange, routingkey, operandsDTO);
	}

}
