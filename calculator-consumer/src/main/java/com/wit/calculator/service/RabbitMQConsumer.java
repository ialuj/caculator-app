package com.wit.calculator.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wit.calculator.exception.CalculatorConsumerException;
import com.wit.calculator.model.dto.OperandsDTO;
import com.wit.calculator.model.service.ICalculatorService;

@Component
public class RabbitMQConsumer implements IRabbitMQConsumer {

	@Value("${calculator.rabbitmq.queue}")
	private String queue;

	@Value("${calculator.rabbitmq.exchange}")
	private String exchange;

	@Value("${calculator.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	private ICalculatorService calculatorService;

	@Override
	@RabbitListener(queues = "${calculator.rabbitmq.queue}")
	public OperandsDTO receivedMessage(OperandsDTO operandsDTO) {
		try {
		if ("+".equals(operandsDTO.getOperationType())) {
			operandsDTO.setResult(calculatorService.sum(operandsDTO.getFirstOperand(), operandsDTO.getSecondOperand()));
		} else if ("-".equals(operandsDTO.getOperationType())) {
			operandsDTO.setResult(
					calculatorService.subtract(operandsDTO.getFirstOperand(), operandsDTO.getSecondOperand()));
		} else if ("*".equals(operandsDTO.getOperationType())) {
			operandsDTO.setResult(
					calculatorService.multiply(operandsDTO.getFirstOperand(), operandsDTO.getSecondOperand()));
		} else if ("/".equals(operandsDTO.getOperationType())) {
			operandsDTO
					.setResult(calculatorService.divide(operandsDTO.getFirstOperand(), operandsDTO.getSecondOperand()));
		} else {
			throw new CalculatorConsumerException("Operacao nao reconhecida");
		}
		return operandsDTO;
		}
		catch(final Exception exception) {
			throw new CalculatorConsumerException(exception.getMessage());
		}
	}
}
