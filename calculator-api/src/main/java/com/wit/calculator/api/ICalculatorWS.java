package com.wit.calculator.api;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICalculatorWS {
	
	public ResponseEntity<BigDecimal> sum(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b);

	public ResponseEntity<BigDecimal> subract(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b);

	public ResponseEntity<BigDecimal> multiply(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b);

	public ResponseEntity<BigDecimal> divide(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b);

}
