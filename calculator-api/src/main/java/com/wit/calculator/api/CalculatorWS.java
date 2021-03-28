package com.wit.calculator.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wit.calculator.model.dto.OperandsDTO;
import com.wit.calculator.service.IRabbitMQSender;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorWS implements ICalculatorWS {
	
	@Autowired
	private IRabbitMQSender rabbitMQSender;

	@Override
	@GetMapping("/sum")
	public ResponseEntity<BigDecimal> sum(BigDecimal a, BigDecimal b) {

		try {
			// sends and receive the message
			final OperandsDTO dto = rabbitMQSender.send(new OperandsDTO(a, b, "+"));

			ResponseEntity<BigDecimal> response = ResponseEntity.ok(dto.getResult());

			return response;
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/subtract")
	public ResponseEntity<BigDecimal> subract(BigDecimal a, BigDecimal b) {
		try {
			// sends and receive the message
			final OperandsDTO dto = rabbitMQSender.send(new OperandsDTO(a, b, "-"));

			// returns the response
			ResponseEntity<BigDecimal> response = ResponseEntity.ok(dto.getResult());

			return response;
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/multiply")
	public ResponseEntity<BigDecimal> multiply(BigDecimal a, BigDecimal b) {
		try {
			// sends and receive the message
			final OperandsDTO dto = rabbitMQSender.send(new OperandsDTO(a, b, "*"));

			ResponseEntity<BigDecimal> response = ResponseEntity.ok(dto.getResult());

			return response;
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	@GetMapping("/divide")
	public ResponseEntity<BigDecimal> divide(BigDecimal a, BigDecimal b) {
		try {
			// sends and receive the message
			final OperandsDTO dto = rabbitMQSender.send(new OperandsDTO(a, b, "/"));

			ResponseEntity<BigDecimal> response = ResponseEntity.ok(dto.getResult());

			return response;
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
