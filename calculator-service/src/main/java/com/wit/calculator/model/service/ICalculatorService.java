package com.wit.calculator.model.service;

import java.math.BigDecimal;

/*
 * Interface that exposes sum, subtract, multiplication and division services
 */
public interface ICalculatorService {

	public BigDecimal sum(final BigDecimal firstOperand, final BigDecimal secondOperand);

	public BigDecimal subtract(final BigDecimal firstOperand, final BigDecimal secondOperand);

	public BigDecimal multiply(final BigDecimal firstOperand, final BigDecimal secondOperand);

	public BigDecimal divide(final BigDecimal firstOperand, final BigDecimal secondOperand);

}
