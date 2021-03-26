package com.wit.calculator.model.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.wit.calculator.business.exception.BusinessException;

/*
 * Implementation of ICalculatorService
 */
@Service
public class CalculatorService implements ICalculatorService {

	@Override
	public BigDecimal sum(BigDecimal firstOperand, BigDecimal secondOperand) {

		validateOperands(firstOperand, secondOperand);

		BigDecimal result = firstOperand.add(secondOperand);

		return result;
	}

	@Override
	public BigDecimal subtract(BigDecimal firstOperand, BigDecimal secondOperand) {

		validateOperands(firstOperand, secondOperand);

		BigDecimal result = firstOperand.subtract(secondOperand);
		return result;
	}

	@Override
	public BigDecimal multiply(BigDecimal firstOperand, BigDecimal secondOperand) {

		validateOperands(firstOperand, secondOperand);

		BigDecimal result = firstOperand.multiply(secondOperand);
		return result;
	}

	@Override
	public BigDecimal divide(BigDecimal firstOperand, BigDecimal secondOperand) {

		validateOperands(firstOperand, secondOperand);

		if (secondOperand.equals(BigDecimal.ZERO)) {
			throw new BusinessException("O divisor nao pode ter valor ZERO!");
		}

		BigDecimal result = firstOperand.divide(secondOperand);
		return result;
	}

	private void validateOperands(BigDecimal firstOperand, BigDecimal secondOperand) {

		if (firstOperand == null || secondOperand == null) {
			throw new BusinessException("Indique os valores dos dois operandos!");
		}
	}

}
