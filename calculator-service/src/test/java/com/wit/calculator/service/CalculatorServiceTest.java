package com.wit.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wit.calculator.business.exception.BusinessException;
import com.wit.calculator.model.service.ICalculatorService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalculatorServiceTest {

	@Autowired
	private ICalculatorService calculatorService;

	@Test
	public void shouldSum() {

		final BigDecimal firtOperand = new BigDecimal(20.0d);
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		final BigDecimal result = calculatorService.sum(firtOperand, secondOperand);
		assertEquals(new BigDecimal(35.0d), result);
	}

	@Test
	public void shouldFailSum() {

		final BigDecimal firtOperand = null;
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		try {
			final BigDecimal result = calculatorService.sum(firtOperand, secondOperand);
			assertEquals(new BigDecimal(45.0d), result);
		} catch (final BusinessException businessException) {
			assertEquals("Indique os valores dos dois operandos!", businessException.getMessage());
		}
	}

	@Test
	public void shouldSubract() {

		final BigDecimal firtOperand = new BigDecimal(20.0d);
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		final BigDecimal result = calculatorService.subtract(firtOperand, secondOperand);
		assertEquals(new BigDecimal(5.0d), result);
	}

	@Test
	public void shouldFailSubract() {

		final BigDecimal firtOperand = null;
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		try {
			final BigDecimal result = calculatorService.subtract(firtOperand, secondOperand);
			assertEquals(new BigDecimal(5.0d), result);
		} catch (final BusinessException businessException) {
			assertEquals("Indique os valores dos dois operandos!", businessException.getMessage());
		}
	}

	@Test
	public void shouldMultiply() {

		final BigDecimal firtOperand = new BigDecimal(20.0d);
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		final BigDecimal result = calculatorService.multiply(firtOperand, secondOperand);
		assertEquals(new BigDecimal(300.0d), result);
	}

	@Test
	public void shouldFailMultiply() {

		final BigDecimal firtOperand = null;
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		try {
			final BigDecimal result = calculatorService.multiply(firtOperand, secondOperand);
			assertEquals(new BigDecimal(300.0d), result);
		} catch (final BusinessException businessException) {
			assertEquals("Indique os valores dos dois operandos!", businessException.getMessage());
		}
	}

	@Test
	public void shouldDivide() {

		final BigDecimal firtOperand = new BigDecimal(20.0d);
		final BigDecimal secondOperand = new BigDecimal(5.0d);

		final BigDecimal result = calculatorService.divide(firtOperand, secondOperand);
		assertEquals(new BigDecimal(4.0d), result);
	}

	@Test
	public void shouldFailDivide() {

		final BigDecimal firtOperand = null;
		final BigDecimal secondOperand = new BigDecimal(15.0d);

		try {
			final BigDecimal result = calculatorService.divide(firtOperand, secondOperand);
			assertEquals(new BigDecimal(45.0d), result);
		} catch (final BusinessException businessException) {
			assertEquals("Indique os valores dos dois operandos!", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailDivideSecondOperandZero() {

		final BigDecimal firtOperand = new BigDecimal(15.0d);
		final BigDecimal secondOperand = BigDecimal.ZERO;

		try {
			final BigDecimal result = calculatorService.divide(firtOperand, secondOperand);
			assertEquals(new BigDecimal(45.0d), result);
		} catch (final BusinessException businessException) {
			assertEquals("O divisor nao pode ter valor ZERO!", businessException.getMessage());
		}
	}

}
