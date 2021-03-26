package com.wit.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wit.calculator.model.dto.OperandsDTO;
import com.wit.calculator.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/calculator-publisher/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b) {

		OperandsDTO operandsDTO = new OperandsDTO(a, b);
		rabbitMQSender.send(operandsDTO);

		return "Message sent to the RabbitMQ calcultarQueue Successfully";
	}

}
