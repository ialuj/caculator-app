/*package com.wit.calculator.model.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wit.calculator.business.exception.BusinessException;
import com.wit.calculator.model.dto.OperandsDTO;
import com.wit.calculator.service.IRabbitMQConsumer;
import com.wit.calculator.service.IRabbitMQSender;

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
	
	private IRabbitMQSender rabbitMQSender;
	
	@Override
	@RabbitListener(queues = "${calculator.rabbitmq.queue}")
	public void receivedMessage(OperandsDTO operandsDTO) {
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
			throw new BusinessException("Operacao nao reconhecida");
		}
		rabbitMQSender.send(operandsDTO);
	}
}*/
