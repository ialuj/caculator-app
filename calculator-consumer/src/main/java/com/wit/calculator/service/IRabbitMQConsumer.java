package com.wit.calculator.service;

import com.wit.calculator.model.dto.OperandsDTO;

public interface IRabbitMQConsumer {
	
	public void receivedMessage(OperandsDTO operandsDTO);
	
}
