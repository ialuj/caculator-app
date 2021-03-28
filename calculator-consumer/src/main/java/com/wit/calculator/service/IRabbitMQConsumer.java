package com.wit.calculator.service;

import com.wit.calculator.model.dto.OperandsDTO;

public interface IRabbitMQConsumer {
	
	public OperandsDTO receivedMessage(OperandsDTO operandsDTO);
	
}
