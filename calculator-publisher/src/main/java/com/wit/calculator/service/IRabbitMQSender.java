package com.wit.calculator.service;

import com.wit.calculator.model.dto.OperandsDTO;

public interface IRabbitMQSender {
	
	public OperandsDTO send(final OperandsDTO operandsDTO);

}
